package week07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935_s3_후위표기식2 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	static Stack<Double> st;
	static int N;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(in.readLine());
		String[] s = in.readLine().split("");

		// 후입선출의 스택 자료구조를 사용하여 값들을 저장함
		st = new Stack<>();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(in.readLine());

		for (int i = 0; i < s.length; i++) {
			double a, b;
			// 값이 입력되면 스택에 저장
			// 연산자가 입력되면 스택에서 값 두개를 꺼내 연산한 결과를 스택에 저장
			switch (s[i]) {
			case "+":
				a = st.pop();
				b = st.pop();
				st.push(b + a);
				break;
			case "-":
				a = st.pop();
				b = st.pop();
				st.push(b - a);
				break;
			case "*":
				a = st.pop();
				b = st.pop();
				st.push(b * a);
				break;
			case "/":
				a = st.pop();
				b = st.pop();
				st.push(b / a);
				break;
			default:
				a = nums[s[i].charAt(0) - 'A'];
				st.push(a);
				break;
			}
		}
		// 자릿수를 맞추기 위해 printf로 출력
		System.out.printf("%.2f", st.pop());
	}
}
