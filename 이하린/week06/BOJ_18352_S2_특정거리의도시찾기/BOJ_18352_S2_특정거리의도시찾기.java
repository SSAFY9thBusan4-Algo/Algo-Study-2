package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352_S2_특정거리의도시찾기 {
	
	/*
	 * 메모리 : 246948KB, 시간 : 792ms
	 * 모든 도로의 거리가 1로 고정되어있기 때문에 BFS 탐색으로 풀었다.
	 */
	
	//인접 리스트 생성을 위한 Node 클래스
	static class Node {
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N; //도시의 개수, 정점의 개수
	static int M; //거리 정보 개수, 간선의 개수
	static int K; //최단 거리 K인 애들만 출력
	static int X; //출발 도시 정보
	
	static int distance[]; //거리 저장 배열
	static Node adjList[]; //인접 리스트
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		//인접 리스트 생성
		adjList = new Node[N+1];
		distance = new int[N+1];
		
		//간선의 개수만큼 반복
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
		}
		
		bfs(X); //bfs 탐색
		
		boolean flag = false; //최단거리가 K인 정점이 존재하면 출력, 아니라면 -1 출력.
		for(int i=1; i<distance.length; i++) {
			if(distance[i] == K) {
				if(!flag) flag = true;
				sb.append(i).append('\n');
			}
		}
		
		if(flag) System.out.println(sb);
		else System.out.println(-1);
		
	}

	private static void bfs(int X) { //BFS 탐색 함수 
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		int dis = 0; //거리 저장 위한 변수.
		
		queue.offer(X);
		visited[X] = true;
		
		int current = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				current = queue.poll();
				distance[current] = dis;
				
				for(Node temp = adjList[current]; temp!= null; temp = temp.link) {
					if(!visited[temp.vertex]) {
						queue.offer(temp.vertex);
						visited[temp.vertex] = true;
					}
				}
			}
			dis++; //다음 레벨로 갈 때 마다 dis를 +1 해준다.
		}
		
		
	}
	
}