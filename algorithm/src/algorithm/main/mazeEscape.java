package algorithm.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class mazeEscape {
	
	
	public static int[][] map;
	public static boolean[][] check;
	public static int[][] direction = {{0,1},{0,-1},{-1,0},{1,0}};
	static int h,w;
	static List<Integer> list= new ArrayList<>();  
	
	
	public static void main(String[] args) throws IOException  {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		 h = Integer.parseInt(st.nextToken());
		 w = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		check = new boolean[h][w];
		for(int i = 0; i < h; i++) {
			String line = bf.readLine();
			for(int k = 0; k < w; k++) {
				map[i][k] = line.charAt(k)-48;
			}
		}
		int cnt = 0;
		dfs(0,0, cnt);
		Collections.sort(list);
		System.out.println(list.get(0));
		
	}

	private static void dfs(int curH, int curW, int cnt) {
		//System.out.println("curH = " + curH + ", curW = " + curW + ", cnt = " + cnt);
		check[curH][curW] = true;
		cnt++;
		
		if(curH == h-1 && curW == w-1) {
			list.add(cnt);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nextH = curH + direction[i][0];
			int nextW = curW + direction[i][1];
			
			if(nextH >= 0 && nextW >= 0 && nextH < h && nextW < w) {
				if(map[nextH][nextW] == 1 && check[nextH][nextW] == false) {
					dfs(nextH, nextW,cnt);
					check[nextH][nextW] = false;
					
				}
			}
			
		}
		cnt--;
	}
	
}
