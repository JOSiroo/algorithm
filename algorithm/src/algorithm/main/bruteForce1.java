package algorithm.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bruteForce1 {
	static int sum;
	static int[] hobit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		hobit = new int[9];
		sum = 0;
		for(int i = 0; i < 9; i++) {
			hobit[i] = sc.nextInt();
			sum += hobit[i];
		}
		for(int i = 0; i < 9; i++) {
			for(int k = 0; k < 9; k++) {
				if(sum - (hobit[i] + hobit[k]) == 100 && i != k) {
					ArrayList<Integer> list = new ArrayList<>();
					int num1 = hobit[i];
					int num2 = hobit[k];
					for(int a : hobit) {
						if(a != num1 && a != num2) {
							list.add(a);
						}
					}
					Collections.sort(list);
					for(int a : list) {

						System.out.println(a);
					}
					return;
				}
			}

		}
	}

}
