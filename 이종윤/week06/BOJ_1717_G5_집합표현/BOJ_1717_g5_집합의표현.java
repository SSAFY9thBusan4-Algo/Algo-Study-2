package week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1717_g5_집합의표현 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int[] parents;
	static int[] ans;
	static int N, M;

	public static void main(String[] args) throws Exception {
		String[] s = in.readLine().split(" ");

		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		parents = new int[N + 1];
		for (int i = 0; i < N + 1; i++)
			parents[i] = i;

		for (int i = 0; i < M; i++) {
			s = in.readLine().split(" ");
			int comp = Integer.parseInt(s[0]);
			int a = Integer.parseInt(s[1]);
			int b = Integer.parseInt(s[2]);
			if (comp == 0) {
				union(a, b);
			} else {
				sb.append((isunion(a, b) ? "YES" : "NO") + "\n");
			}
		}

		System.out.println(sb);
	}

	// 루트 노드를 반환
	static int findset(int n) {
		if (n == parents[n])
			return n;
		return parents[n] = findset(parents[n]);
	}

	// 두 집합을 합침
	static void union(int a, int b) {
		int aroot = findset(a);
		int broot = findset(b);
		// 루트 노드가 같으면 이미 같은 집합에 속함
		// 루트 노드가 다르면 루트를 수정하여 하나의 집합으로 합침
		if (aroot != broot)
			parents[broot] = aroot;
	}

	// 같은 집합인지 확인
	static boolean isunion(int a, int b) {
		int aroot = findset(a);
		int broot = findset(b);
		// 루트가 같으면 같은 집합에 속함
		if (aroot == broot)
			return true;
		// 루트가 다르면 다른 집합에 속함
		return false;
	}
}
