package algorithm.main;
import java.util.Scanner;

public class Main6 {
	static int kg;
	static int[] arr = {12,9,6,3};
	static int targetNum;
	static int result;
	static void sugar3(int inputKg) {
		if(inputKg % 3 == 0) {
			result += inputKg / 3;
			return;

		}else {
			result = -1;
			return;
		}
	}
	static void sugar5(int inputKg) {
		for(int i = 0; i < 4; i++) {
			if(inputKg % 5 == arr[i]) {
				result += inputKg / 5;
				targetNum = arr[i];
				break;
			}
		}
		if(inputKg == 0) {
			result = -1;
			return;
		}else if(inputKg % 5 ==0) {
			result += inputKg / 5;
			return;
		}else if(inputKg % 5 == 1) {
			result += (inputKg - 6)  / 5;
			targetNum = 6;
		}else if(inputKg % 5 == 4 && inputKg != 4) {
			result += (inputKg - 9) / 5;
			targetNum = 9;
		}else if(inputKg % 5 == 2 && inputKg != 7) {
			result += (inputKg - 12) / 5;
			targetNum = 12;
		}
		if(targetNum == 0 ) {
			sugar3(inputKg);
		}else {
			sugar3(targetNum);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		kg = sc.nextInt();
		result = 0;
		sugar5(kg);
		System.out.println(result);
	}
}
