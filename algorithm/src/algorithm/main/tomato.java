package algorithm.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class tomato {
	public static int n,m;
	public static int[][] box;
	public static boolean[][] check;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void bfs(int x, int y) {
		box[x][y] = 1;
		
		for(int i = 0; i < 4; i++) {
			int tempX = x + move[i][0];
			int tempY = y + move[i][1];
			if(tempX >= 0 && tempY >= 0 && tempX < n && tempY < m) {
				if(box[tempX][tempY] == 0) {
					box[tempX][tempY] = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		box = new int[n][m];
		check = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int k = 0; k < m; k++) {
				box[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		int days = 0;
		for(int i = 0; i < n; i++) {
			for(int k = 0; k <m; k++) {
				if(box[i][k] == 1) {
					bfs(i,k);
					days++;
				}
			}
		}
		System.out.println(days);
		
	}

}
