package BOJ_9084_G5_동전;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9084_G5_동전 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(in.readLine());
			int[] Array = new int [N];
			String[] split = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				Array[j] = Integer.parseInt(split[j]);
			}
			int M = Integer.parseInt(in.readLine());
			sb.append(coin(M,Array)).append("\n");
		}
		System.out.println(sb);
	}

	private static int coin(int M, int[] Array) {
		int[] coin = new int[M + 1];
		coin[0] = 1;
		for (int coins : Array) {
			for (int j = coins; j <= M; j++) {
				coin[j] += coin[j-coins];
			}
		}
		return coin[M];
	}
}
