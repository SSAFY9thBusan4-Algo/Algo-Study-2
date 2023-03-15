package alhorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class stack {
	public static void main(String[] args) throws Exception{
		Deque<String> stack = new ArrayDeque<>(); // deque라이브러리를 이용하여 stack 구현
		BufferedReader readline = new BufferedReader(new InputStreamReader(System.in));
		String in = readline.readLine();
		int N = Integer.parseInt(in);
		String[] split = new String[2];
		for(int i = 0; i < N; i++) {
			split = readline.readLine().split(" "); //해야할 작업 판별  
			if (split[0].equals("push")) { //push이면 
				stack.add(split[1]); //stack에 추가
			}else if (split[0].equals("pop")) { //pop이면 
				if (stack.isEmpty()) { //stack이 비어있는지 확인 
					System.out.println(-1); //비어있으면 pop할 수 없으므로 -1 출력
				}else { //비어있지 않으면
					System.out.println(stack.pollLast()); //가장 마지막 데이터 pop
				}
			}else if (split[0].equals("size")) { //size이면 
				System.out.println(stack.size()); //stack의 size 출력
			}else if (split[0].equals("empty")) { //empty이면
				if (stack.isEmpty()) { //stack이 비어있는지 확인
					System.out.println(1); //비어있으면 1 출력	
				}else {
					System.out.println(0); //비어있지 않으면 0 출력
				}
			}else {	//top이면
				if (stack.isEmpty()) { //비어있는지 확인
					System.out.println(-1); //비어있으면 top이 없으므로 -1출력		
				}else {
					System.out.println(stack.peekLast()); //비어있지 않으면 가장 마지막데이터 출력
				}
			}
		}
	}
}
