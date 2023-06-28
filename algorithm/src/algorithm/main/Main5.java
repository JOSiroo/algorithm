package algorithm.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {
	static int node;
	static int edge;
	static int map[][];
	static boolean[] visited;
	static int cnt;
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static void dfs(int input) {
		visited[input] = true;
		cnt++;
		for(int i = 1; i <= node; i++) {
			if(map[input][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine());
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		map = new int[node+1][node+1];
		visited = new boolean[node+1];
		for(int i = 0; i < edge; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;						// x,y 가 연결되어있다면 y,x도 연결되어있다는 뜻
		}
		int count = 0;
		for(int i = 1; i <= node; i++) {
			cnt = 0;
			for(int k = 1; k <= node; k++) {
				if(!visited[i]) {
					dfs(i);
					if(cnt > 0) {
						count++;
						cnt = 0;
					}
				}
			}
		}
		System.out.println(count);
	}

}
