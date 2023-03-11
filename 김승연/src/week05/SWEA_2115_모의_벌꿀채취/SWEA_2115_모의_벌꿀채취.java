package week05.SWEA_2115_모의_벌꿀채취;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_모의_벌꿀채취 {

	static int N, M, C;
	static int[][] map;
	static int r1, c1;
	static int r2, c2;
	static int maxSum;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken()); //크기
			M = Integer.parseInt(st.nextToken()); //벌통선택
			C = Integer.parseInt(st.nextToken()); //꿀의 최대 양
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			//logic
			/*
			 * 꿀을 채취할 수 있는 M개의 벌통을 두 번(일꾼1, 일꾼2) 선택해야 함.
			 * M개의 벌통은 가로로 연속되어야 하고, 일꾼1의 벌통들과 일꾼2의 벌통들은 겹칠 수 없음.
			 * 따라서 조합으로 풀이
			 * 
			 */
			
			//일꾼1의 M개의 벌통들의 시작점을 고름(r1, r2)
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N-M + 1; c++) {
					r1 = r;
					c1 = c;
					choice2(r, c + M); //일꾼 1의 M개의 벌통들이 끝나는 시점 다음(r, c+M)부터 일꾼 2의 M개의 벌통들을 고름
				}
			}
			sb.append(maxSum).append("\n");
			maxSum = 0;
		}
		System.out.println(sb);
	}
	private static void choice2(int startR, int startC) {
		//일꾼 2의 M개의 벌통의 시작점을 고름
		
		//일꾼 1과 같은 row일 경우
		for (int c = startC; c < N-M+1; c++) {
			r2 = startR;
			c2 = c;
			select(); //고르고 select
		}
		
		//일꾼 2 다음 row일 경우
		for (int r = startR+1; r < N; r++) {
			for (int c = 0; c < N-M+1; c++) {
				r2 = r;
				c2 = c;
				select(); //고르고 select
			}
		}
	}
	private static void select() {
		//일꾼들이 고른 벌통들 중, 합이 C를 넘지 않고 최대의 양을 얻기 위해 부분집합을 이용해서 최대 이익을 구함.
		
		//일꾼1: r1, c1 부분집합
		subSum = 0;
		subset(r1, c1, 0, 0, 0);
		sum1 = subSum;
		
		//일꾼2: r2, c2 부분집합
		subSum = 0;
		subset(r2, c2, 0, 0, 0);
		sum2 = subSum;
		
		maxSum = Math.max(maxSum, sum1 + sum2);
	}
	
	static int sum1, sum2, subSum;
	private static void subset(int r, int c, int sum, int powSum, int len) {
		//부분집합 구하는 함수
		//M개의 벌통을 다 봤거나, 합이 C를 넘는 경우 이익의 값(제곱의 합)을 리턴
		if (len == M) {
			subSum = Math.max(subSum, powSum);
			return;
		}
		
		int nextSum = sum + map[r][c];
		int nextPowSum = powSum + (int)Math.pow(map[r][c], 2);
		if (nextSum > C) {
			subSum = Math.max(subSum, powSum);
			return;
		}
		
		//부분집합 처리
		//포함
		subset(r, c+1, nextSum, nextPowSum, len + 1);
		//미포함
		subset(r, c+1, sum, powSum, len + 1);
	}
}
