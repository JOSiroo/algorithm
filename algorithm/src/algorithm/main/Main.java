package algorithm.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static char[] chess = {'B','W'};
	static String[] typeA = {"BWBWBWBW",
							"WBWBWBWB",
							"BWBWBWBW",
							"WBWBWBWB",
							"BWBWBWBW",
							"WBWBWBWB",
							"BWBWBWBW",
							"WBWBWBWB"};
	
	static String[] typeB = {"WBWBWBWB",
							"BWBWBWBW",
							"WBWBWBWB",
							"BWBWBWBW",
							"WBWBWBWB",
							"BWBWBWBW",
							"WBWBWBWB",
							"BWBWBWBW"};
	static ArrayList<Integer> list; 
	static int n;
	static int m;
	public static int func(int i, int k, String[] arr) {
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		int iii = 0;
		for(int ii = i; ii < i+8; ii++) {
			int kkk = 0;
			for(int kk = k; kk < k+8; kk++) {
				if(arr[ii].charAt(kk) != typeA[iii].charAt(kkk)){
					result1++;
				}
				if(arr[ii].charAt(kk) != typeB[iii].charAt(kkk)){
					result2++;
				}
				kkk++;
			}
			iii++;
		}
		if(result1 > result2) {
			result3 = result2;
		}else {
			result3 = result1;
		}
		return result3;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		String[] board = new String[n];
		for(int i = 0; i < n; i++) {
			String line = bf.readLine();
			board[i] = line;
		}
		ArrayList<Integer> list = new ArrayList();
		int cnt = 0;
		for(int i = 0; i <= n-8; i++) {
			for(int k = 0; k <= m-8; k++) {
				cnt = func(i,k,board);
				list.add(cnt);
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}
}
