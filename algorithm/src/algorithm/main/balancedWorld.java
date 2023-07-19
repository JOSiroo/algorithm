package algorithm.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class balancedWorld {

	public static void main(String[] args) throws IOException {
		//4949 균형잡힌 세상 * 자료구조 / 문자열 / 스택
		//() [] 괄호들의 균형이 전부 잡혀있으면 yes 아니면 no
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line = bf.readLine()) != null){

			if(line.equals(".")) {
				break;
			}

			Stack<Character> stack = new Stack<>();
			StringBuilder sb1 = new StringBuilder();
			for(int i = 0; i <line.length(); i++) {
				if(line.charAt(i)=='(' || line.charAt(i)==')' 
						|| line.charAt(i)=='[' || line.charAt(i)==']') {
					sb1.append(line.charAt(i));
				}
			}

			if(sb1.length() == 0) {
				System.out.println("yes");
				continue;
			}

			if(sb1.charAt(0) == ')' || sb1.charAt(0) == ']') {
				System.out.println("no");
				continue;
			} 

			if(sb1.length() > 0) {
				for(int i = 0; i < sb1.length(); i++) {
					char lastVal = ' ';

					if(sb1.charAt(i) == '(' || sb1.charAt(i) == '[') {
						stack.push(sb1.charAt(i));
					}else if(sb1.charAt(i) == ')') {
						if(stack.size() > 0) {
							lastVal = stack.peek();
							if(lastVal == '(') {
								stack.pop();
							}
						}
					}else if(sb1.charAt(i) == ']') {
						if(stack.size() > 0) {
							lastVal = stack.peek();
							if(lastVal == '[') {
								stack.pop();
							}
						}
					}
				}
				if(stack.size()==0) {
					System.out.println("yes");
					continue;
				}else {
					System.out.println("no");
					continue;
				}
			}else {
				System.out.println("yes");
				continue;
			}
		}
	}	
}
