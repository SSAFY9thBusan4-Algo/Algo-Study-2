package week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_14567_g5_선수과목 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static List<Integer>[] pre;
	static boolean[][] take;
	static int[] ans;
	static int N, M;

	public static void main(String[] args) throws Exception {
		String[] s = in.readLine().split(" ");

		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		pre = new ArrayList[N + 1];
		take = new boolean[1001][N + 1];
		ans = new int[N + 1];
		for (int i = 1; i < N + 1; i++)
			pre[i] = new ArrayList<>();

		// 각 과목의 선수 과목들을 리스트로 관리
		for (int i = 0; i < M; i++) {
			s = in.readLine().split(" ");
			int prev = Integer.parseInt(s[0]);
			int aft = Integer.parseInt(s[1]);
			pre[aft].add(prev);
		}

		// 각 과목을 이수하기까지 걸리는 학기 수를 계산
		DP();
		
		// 각 과목을 이수하기까지 걸리는 학기 수를 출력
		for (int i = 1; i < N + 1; i++)
			sb.append(ans[i] + " ");

		System.out.println(sb);
	}

	static void DP() {
		int cnt = 0;
		int sem = 1;
		
		// 해당 학기에 이수한 과목이 N개이면 모든 과목을 이수한 것
		while (cnt < N) {
			cnt = 0;
			
			// 매 학기마다 모든 과목에 대해서 이수여부를 확인
			for (int i = 1; i < N + 1; i++)
				if (take[sem][i] = take(i, sem))
					cnt++;
			sem++;
		}
	}

	static boolean take(int subject, int sem) {
		// 이미 이수한 경우
		if (take[sem - 1][subject])
			return true;
		
		// 아직 선수과목을 모두 이수하지 못한 경우
		for (int i : pre[subject])
			if (!take[sem - 1][i])
				return false;
		
		// 선수과목을 모두 이수하여 해당 과목을 이수할 수 있는 경우
		ans[subject] = sem;
		return true;
	}
}
