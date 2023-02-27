package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15651_S3_N과M {
	private static int[] numbers;
	private static int M, N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		permutation(0);
		System.out.println(sb);
	}
	
	private static void permutation(int cnt) { // cnt : 기존까지 던져진 주사위 수 ==> 현재 주사위 수를 기록하기 위한 인덱스로 사용
		if(cnt == N) { // 던져진 주사위가 목표수가 되었다면 더이상 던질 주사위 없음
 			for(int i = 0; i < N; i++) {
 				sb.append(numbers[i] + " ");
 			}
 			sb.append("\n");
 			return;
 		}
		for (int i = 1; i <= M; i++) {
 			numbers[cnt] = i;
 			// 다음 주사위 던지러 가기
 			permutation(cnt + 1);
 			
 		}
	}
}
