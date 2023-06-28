package algorithm.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main3 {
	static int tiles;
	static int map[][];
	static boolean check[][];
	static int cnt;
	static int count;
	static HashSet<Integer> rainfall;	// => 증가하는 강수량 [0 ~ 지도의 최대 높이]
	static int[][] nextXY = {{1,0},{0,1},{-1,0},{0,-1}};

	static void dfs(int x, int y, int currRainfall) {
		check[x][y] = true;
		cnt++;
		for(int i = 0; i < 4; i++) {
			int tempX = x + nextXY[i][0]; 
			int tempY = y + nextXY[i][1];
			if(tempX >= 0 && tempY >= 0 && tempX < tiles && tempY < tiles) {
				if(!check[tempX][tempY] && map[tempX][tempY] > currRainfall) {
					dfs(tempX,tempY,currRainfall);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		tiles = Integer.parseInt(bf.readLine());
		map = new int[tiles][tiles];
		rainfall = new HashSet<>();
		for(int i = 0; i < tiles; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int k = 0; k < tiles; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
				rainfall.add(map[i][k]);
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		Iterator<Integer> iter = rainfall.iterator();
		while(iter.hasNext()) {
			list.add(iter.next());
		}
		int temp = 0;
		for(int i = 0; i < list.size(); i++) {
			check = new boolean[tiles][tiles];
			count = 0;
			for(int out = 0; out < tiles; out++) {
				for(int in = 0; in < tiles; in++) {
					if(map[out][in] > list.get(i) && !check[out][in]) {
						cnt = 0;
						dfs(out,in,list.get(i));
						if(cnt >= 1) {
							count++;
						}
					}
				}
			}
			if(count > temp) {
				temp = count;
			}
		}
		System.out.println(temp);



	}
}
