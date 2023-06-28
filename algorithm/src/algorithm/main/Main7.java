package algorithm.main;
import java.util.Scanner;

public class Main7 {
	static int sec;
	static int result;
	static int[] cnt = {0,0,0};
	public static void func(int sec) {
		if(sec >= 300) {
			cnt[0] += sec/300;
			sec = sec%300;
		}else
		if(sec >= 60) {
			cnt[1] += sec/60;
			sec = sec%60;
		}else
		if(sec >= 10) {
			cnt[2] += sec/10;
			sec = sec%10;
		}else if(sec == 0){
			return;
		}else {
			result = -1;
			return;
		}
		func(sec);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		sec = sc.nextInt();
		func(sec);
		if(result == -1) {
			System.out.println(-1);
		}else {
			for(int a : cnt) {
				System.out.print(a + " ");
			}
		}
	}
}