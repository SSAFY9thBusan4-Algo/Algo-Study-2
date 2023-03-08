package ssafy.com.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 메모리 : 124560KB 시간 : 592ms
 * 메모리가 .. 어마무시
 * 수업시간 푼 코드 응용하니까 풀렸던 문제
 * 위상정렬 첨 보지만 .. 열심히 공부.. 
 */

public class BOJ_14567_G5_선수과목 {
	
	//인접 리스트를 위한 클래스 생성
	static class Node {
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M; //정점 개수, 간선 개수
	static Node[] adjList; //인접 리스트
	static int [] inDegree; //들어오는 차수 저장 배열
	static int [] level;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//배열 초기화
		adjList = new Node[N+1];
		inDegree = new int[N+1];
		level = new int[N+1];
		
		for(int i=0; i<M; i++) {
			//그래프 정보 입력
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}
		
		topologySort();
		
		for(int i=1; i<=N; i++) {
			sb.append(level[i]).append(' ');
		}
		
		System.out.println(sb);
		
	}
	
	static void topologySort() {
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) queue.offer(i);
		} //진입 차수가 0인 정점 큐에 넣기
		int lev = 1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				int cur = queue.poll();
				level[cur] = lev;
				
				//현재 정점을 기준으로 인접 정점 처리
				for(Node temp = adjList[cur]; temp!= null; temp = temp.link) {
					if(--inDegree[temp.vertex] == 0) {
						queue.offer(temp.vertex);
					}
				}
			}
			lev++;
			
		}
	
	}
	
}