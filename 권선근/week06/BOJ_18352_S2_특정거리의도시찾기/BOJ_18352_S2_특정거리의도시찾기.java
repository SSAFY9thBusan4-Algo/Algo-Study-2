package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;
//다익트라 알고리즘 사용
public class BOJ_18352_S2_특정거리의도시찾기 {
	static int N,M,K,X;
	// X 도시에서부터의 거리 정보
	static int distance[];
	static Node[] nodes;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		nodes = new Node[N+1];
		for(int i=1;i<=N;i++) {
			nodes[i] = new Node(i);
		}
		for(int i=0;i<M;i++) {
			int line[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			nodes[line[0]].conn.add(line[1]);
			//nodes[line[1]].conn.add(line[0]);
		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		// 시작도시 까지의 거리는 0! , 큐에 시작노드를 삽입한다.
		distance[X] = 0;
		pq.add(nodes[X]);
		
		// 큐애서 꺼낸 노드 temp
		// temp에서 나갈수 있는 노드번호 idx
		// temp에서 idx로 가는 결과가 이전 distance[idx]보다 작다면
		// 갱신하고 큐에 넣는다.
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			
			for(int idx : temp.conn) {
				if(distance[temp.idx] + 1 < distance[idx]) {
					distance[idx] = distance[temp.idx] + 1;
					pq.add(nodes[idx]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		// 최단거리가 K인 도시들을 기록한다.
		for(int i=1;i<=N;i++) {
			if(distance[i] == K) {
				sb.append(i+"\n");
			}
		}
		// 최단거리가 K인 도시의 수 출력 , 0이면 -1출력
		if(sb.length() == 0) {
			System.out.println("-1");
		}
		else {
			System.out.println(sb.toString());
		}
	}
	static class Node implements Comparable<Node> {
		int idx;
		ArrayList<Integer> conn;
		public Node(int idx) {
			super();
			this.idx = idx;
			conn = new ArrayList<Integer>();
		}
		@Override
		public int compareTo(Node o) {
			return distance[this.idx] - distance[o.idx];
		}
		
	}
	
}