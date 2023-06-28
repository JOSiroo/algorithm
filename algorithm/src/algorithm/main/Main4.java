package algorithm.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4 {
	static int size;
	static char map[][];
	static boolean check[][];
	static boolean check2[][];
	static int[][] nextXY = {{1,0},{0,1},{-1,0},{0,-1}}; 
	static int cnt;
	static int cnt2;
	static int count;
	static int count2;
	static char[] RGB = {'R','G','B'};
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static void common(int x, int y) {
		check[x][y] = true;
		cnt++;
		for(int i = 0; i < 4; i++) {
			int currX = x + nextXY[i][0];
			int currY = y + nextXY[i][1];

			if(currX >= 0 && currY >= 0 && currX < size && currY < size) {
				if(!check[currX][currY] && map[currX][currY] == map[x][y]) {
					common(currX, currY);
				}
			}
		}
	}	
	static void weakness(int x , int y) {
		check2[x][y] = true;
		cnt2++;
		boolean isRorG = false;
		if(map[x][y] != 'B') {
			isRorG = true;
		}
		for(int i = 0; i < 4; i++) {
			int currX = x + nextXY[i][0];
			int currY = y + nextXY[i][1];

			if(currX >= 0 && currY >= 0 && currX < size && currY < size) {	//맞음
				if(!check2[currX][currY]) {									//방문 안한곳이라면
					if(map[currX][currY] == map[x][y]){						//currXY가 현재랑값이 같으면
						weakness(currX, currY);
					}else if(isRorG) {
						if( map[currX][currY] == 'R' || map[currX][currY] == 'G'){	// 현재 R이나 G여야 하고
							weakness(currX,currY);													// currXY가 R이나 G
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		size = Integer.parseInt(bf.readLine());
		map = new char[size][size];
		check = new boolean[size][size];
		check2 = new boolean[size][size];

		for(int i = 0; i < size; i++) {
			String line = bf.readLine(); 
			for(int k = 0; k < size; k++) {
				map[i][k] = line.charAt(k);
			}
		}
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				if(!check[i][k]) {
					cnt = 0;
					common(i,k);
					if(cnt >= 1) {
						cnt = 0;
						count++;
					}
				}
				if(!check2[i][k]) {
					cnt2 = 0;
					weakness(i,k);
					if(cnt2 >= 1) {
						cnt2 = 0;
						count2++;
					}
				}
			}
		}
		System.out.println(count + " " + count2);
	}
}
