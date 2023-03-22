package week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1197_g4_최소스패닝트리 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int[] parents;
	static Edge[] edgelist;
	static int N, M;

	public static void main(String[] args) throws Exception {
		String[] s = in.readLine().split(" ");

		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		parents = new int[N];
		for (int i = 0; i < N; i++)
			parents[i] = i;
		edgelist = new Edge[M];

		for (int i = 0; i < M; i++) {
			s = in.readLine().split(" ");
			int from = Integer.parseInt(s[0]) - 1;
			int to = Integer.parseInt(s[1]) - 1;
			int weight = Integer.parseInt(s[2]);
			edgelist[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edgelist);

		int result = 0;
		for (Edge e : edgelist) {
			if (union(e.from, e.to)) {
				result += e.weight;
			}
		}
		sb.append(result);

		System.out.println(sb);
	}

	static int findset(int n) {
		if (n == parents[n])
			return n;
		return parents[n] = findset(parents[n]);
	}

	static boolean union(int a, int b) {
		int aroot = findset(a);
		int broot = findset(b);
		if (aroot == broot)
			return false;

		parents[broot] = aroot;
		return true;
	}

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}