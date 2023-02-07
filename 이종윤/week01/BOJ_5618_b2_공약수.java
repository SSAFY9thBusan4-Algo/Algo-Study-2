package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5618_b2_공약수 {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		// n개의 정수 입력
		int n = Integer.parseInt(in.readLine());
		int[] num = new int[n];
		String[] s = in.readLine().split(" ");

		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(s[i]);

		// 입력 받은 모든 정수들에 대해서 최대공약수를 구함
		int d = num[0];
		for (int i = 1; i < n; i++)
			d = div(d, num[i]);

		// 최대공약수의 약수를 모두 출력
		for (int i = 1; i <= d; i++)
			if (d % i == 0)
				sb.append(i + "\n");
		System.out.println(sb);
	}

	// 두 정수의 최대 공약수를 리턴하는 함수
	// 유클리드 호제법
	static int div(int p, int q) {
		return q == 0 ? p : div(q, p % q);
	}
}