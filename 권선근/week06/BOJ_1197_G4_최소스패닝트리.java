package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class BOJ_1197_G4_최소스패닝트리 {
	static boolean visited[];
	static int V,E;
	static ArrayList<Edge> edges[];
	public static void main(String[] args) throws IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		V = line[0];
		E = line[1];
		// 방문한 노드를 나타내는 배열
		visited = new boolean[V+1];
		// 각 노드별로 연결된 간선들을 저장한다.
		edges = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			edges[i] = new ArrayList<Edge>();
		}
		for(int i=0;i<E;i++) {
			line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			edges[line[0]].add(new Edge(line[1],line[2]));
			edges[line[1]].add(new Edge(line[0],line[2]));
		}
		
		// 정점보다 간선이 10배이상 많을 수 있으므로 Prim 알고리즘을 사용하였다.
		//prim 큐에서는 거리가 가장 짧은 노드들부터 빠져나온다.
		PriorityQueue<Node> prim = new PriorityQueue<Node>();
		// 임의의 최초 노드 (여기서는 1번 노드) 와 거기까지의 거리 0을 큐에 삽입한다.
		prim.offer(new Node(1,0));
		int result = 0;
		// V개 노드들을 방문하기 위해서는 V번만 돌면 된다!
		for(int i=0;i<V;i++) {
			Node temp;
			// 방문하지 않은 노드가 나올떄까지 큐에서 뽑는다.
			do {
				temp = prim.poll();
			} while(visited[temp.idx]);
			//큐에서 뽑은 방문하지 않는 노드에 대해 방문처리한다.
			visited[temp.idx] = true;
			result += temp.distance;
			// 현재 노드와 연결된 모든 노드들에 대해 큐에 삽입한다.
			for(Edge edge : edges[temp.idx]) {
				if(!visited[edge.to]) {
					prim.offer(new Node(edge.to , edge.distance));
				}
			}
			
		}
		System.out.println(result);
	}
	// 노드 정보
	private static class Node implements Comparable<Node> {
		int idx;
		int distance;
		public Node(int idx, int distance) {
			super();
			this.idx = idx;
			this.distance = distance;
		}
		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
		
	}
	// 간선 정보
	private static class Edge {
		int to;
		int distance;
		public Edge(int to, int distance) {
			super();
			this.to = to;
			this.distance = distance;
		}
		
	}
}