package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197_G4_최소스패닝트리 {
	
	/*
	 * 수업시간에 배운 크루스칼 알고리즘 사용
	 * 메모리 : 49252KB 시간 : 640ms
	 */
	
	//크루스칼 알고리즘
	
	//Edge 클래스 사용 
	private static class Edge implements Comparable<Edge> {
		
		public int from; 
		public int to;
		public int weight; // 가중치  
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			//가중치 오름차순 정렬  
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	private static int V, E;
	private static Edge[] edgeList;
	private static int[] parents;
	
	
	// 집합 생성 
	private static void makeSet() {
		parents = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
	}
	
	// a의 대표자 찾기 
	private static int findSet(int a) {
		if(parents[a] == a) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	//a가 대표자인 집합과 b가 대표자인 집합 union 
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(A, B, C);
		}
		
		Arrays.sort(edgeList);
		
		makeSet();
		
		int result = 0;
		int count = 0;
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				
				if(++count == V - 1) break;
			}
		}
		
		System.out.println(result);
	}
}