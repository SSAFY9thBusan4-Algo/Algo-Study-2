package week07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_15681_g5_트리와쿼리 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int[] query;
	static List<Integer>[] children;
	static boolean[] v;
	static int N, R, Q;

	public static void main(String[] args) throws Exception {
		String[] s = in.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		R = Integer.parseInt(s[1]);
		Q = Integer.parseInt(s[2]);

		// query는 해당 노드를 정점으로 하는 서브트리의 노드 개수
		query = new int[N + 1];
		// DFS 탐색을 위한 visit 배열
		v = new boolean[N + 1];
		// 해당 정점과 연결된 정점의 인접 리스트
		children = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			children[i] = new ArrayList<>();
		}

		// 인접 리스트 생성
		for (int i = 0; i < N - 1; i++) {
			s = in.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			children[a].add(b);
			children[b].add(a);
		}
		
		// 최상위 노드부터 DFS 탐색
		v[R] = true;
		DFS(R);

		// 서브트리의 노드 개수 출력
		for (int i = 0; i < Q; i++) {
			int q = Integer.parseInt(in.readLine());
			sb.append(query[q] + "\n");
		}

		System.out.println(sb);
	}

	static int DFS(int n) {
		int cnt = 1;
		// 인접 리스트의 서브 트리 개수를 더함
		// 탐색 순서가 최상위부터 최하위 순으로 진행됨
		// 따라서 해당 노드의 하위 노드들의 서브트리 개수가 해당 노드에 더해지고 그 결과값이 상위 노드로 전달됨
		for (int child : children[n]) {
			if (v[child])
				continue;
			v[child] = true;
			cnt += DFS(child);
		}
		query[n] = cnt;

		return cnt;
	}
}
