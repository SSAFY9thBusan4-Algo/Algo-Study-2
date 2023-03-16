package week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class BOJ_18352_s2_특정거리의도시찾기 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static List<Integer>[] conn;
	static int[] dist;
	static int N, M, K, X;

	public static void main(String[] args) throws Exception {
		String[] s = in.readLine().split(" ");

		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		X = Integer.parseInt(s[3]);
		
		// 연결된 도시를 유향 그래프 형태로 저장
		conn = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++)
			conn[i] = new ArrayList<>();
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;

		for (int i = 0; i < M; i++) {
			s = in.readLine().split(" ");
			int from = Integer.parseInt(s[0]);
			int to = Integer.parseInt(s[1]);
			conn[from].add(to);
		}

		// 도시 X로부터 다른 도시까지의 거리 탐색
		bfs();
		
		// 특정 거리의 도시 탐색
		int cnt = 0;
		for (int i = 1; i < N + 1; i++)
			if (dist[i] == K) {
				cnt++;
				sb.append(i + "\n");
			}
		// 특정 거리의 도시가 없을 경우 -1 출력
		if (cnt == 0)
			sb.append(-1);

		System.out.println(sb);
	}

	static void bfs() {
		// BFS를 통해 갈 수 있는 모든 도시에 대해서 최단거리 탐색
		boolean[] v = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(X);

		while (!q.isEmpty()) {
			int n = q.poll();

			if (v[n])
				continue;
			v[n] = true;

			for (int i : conn[n]) {
				if (v[i])
					continue;
				dist[i] = Math.min(dist[i], dist[n] + 1);
				q.offer(i);
			}
		}
	}
}
