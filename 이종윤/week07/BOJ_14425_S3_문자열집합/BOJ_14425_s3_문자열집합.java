package week07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_14425_s3_문자열집합 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static Map<String, Integer> codes;
	static int N, M;

	public static void main(String[] args) throws Exception {
		String[] s = in.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		// 문자열 집합 S를 담을 Map 자료구조
		// key 값으로 빠르게 접근 가능한 장점을 이용하며 value 값은 사용하지 않음
		codes = new HashMap<>();
		for (int i = 0; i < N; i++)
			codes.put(in.readLine(), 0);

		// 문자열을 입력받아 집합 S에 있으면 cnt를 증가시킴
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String str = in.readLine();
			if (codes.containsKey(str))
				cnt++;
		}
		// cnt출력
		sb.append(cnt);
		System.out.println(sb);
	}
}
