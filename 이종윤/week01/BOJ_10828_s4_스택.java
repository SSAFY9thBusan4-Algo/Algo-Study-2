package week01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10828_s4_스택 {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(in.readLine());

		// 배열과 크기로 스택 구현
		// 최대 n번의 push를 받을 수 있으므로 스택은 n개를 넘게 쌓이지 못함
		int[] stack = new int[n];
		int size = 0;

		// n번의 입력 반복
		for (int i = 0; i < n; i++) {
			String[] s = in.readLine().split(" ");
			switch (s[0]) {
			// push 명령
			// size는 스택의 가장 앞쪽의 비어있는 위치를 가리키고 해당 위치에 값이 채워지면 다음 위치를 가리킴
			case "push":
				stack[size++] = Integer.parseInt(s[1]);
				break;
			// 스택의 마지막에 들어온 값을 출력하고 size를 하나 줄임
			// 스택이 비어있으면 -1을 출력
			case "pop":
				sb.append((size > 0 ? stack[--size] : -1) + "\n");
				break;
			// 현재 스택에 담긴 값의 수를 출력
			case "size":
				sb.append(size + "\n");
				break;
			// 현재 스택이 비어있으면 1, 비어있지 않으면 0을 출력
			// 삼항 연산자로 구현
			case "empty":
				sb.append((size > 0 ? "0" : "1") + "\n");
				break;
			//
			case "top":
				sb.append((size > 0 ? stack[size - 1] : -1) + "\n");
				break;
			}
		}

		System.out.println(sb);
	}
}