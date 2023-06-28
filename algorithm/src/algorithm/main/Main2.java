package algorithm.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2 {
	static int width;
	static int height;
	static char[][] node;
	static boolean[][] visited;
	static int[] alphabet;
	static int[] nextX = {1,0,-1,0};
	static int[] nextY = {0,1,0,-1};
	static int cnt;
	static ArrayList<Integer> resultList;
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		alphabet[node[x][y]-65] += 1;
		
		boolean bool = false;
		
		for(int i = 0; i < 4; i++) {
			int X = x + nextX[i];
			int Y = y + nextY[i];
			if(X >= 0 && Y >= 0 && X < height && Y < width) {
				if((alphabet[node[X][Y]-65])==0 && !visited[X][Y]) {
					bool = true;
					cnt++;
					dfs(X,Y);
					cnt--;
					visited[X][Y] = false;
					alphabet[node[X][Y]-65] = 0;
				}
			}
		}
		if(!bool) {
			resultList.add(cnt+1);
			return;
		}else {
			return;
		}
	}
	//2	4
	//CAAB
	//ADCB
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		node = new char[height][width];
		visited = new boolean[height][width];
		alphabet = new int[26];
		cnt = 0;
		resultList = new ArrayList<>();
		for(int i = 0; i < height; i++) {
			String line = bf.readLine();
			
			for(int k = 0; k < width; k++) {
				char input = line.charAt(k);
				node[i][k] = input;
			}
		}
		dfs(0,0);
		Collections.sort(resultList,Collections.reverseOrder());
		System.out.println(resultList.get(0));
	}
}
