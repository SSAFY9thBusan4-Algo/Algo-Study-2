package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class BOJ_14567_G5_선수과목 {
	static int N , M;
	static int result[];
	static int to_study[];
	static ArrayList<Integer> conn[];
	static ArrayList<Integer> after[];
	public static void main(String[] args) throws IOException {
		// 큐에 선수과목이 없는 과목들 집어넣기
		// 큐에서 뽑은 과목이 선수과목인 과목들을 큐에 넣는다.
		// 큐에서 뽑은 과목의 선수과목들이 모두 수료되었다면 X학기 수강
		// else 수료되지 않았다면 리턴
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = line[0];
		M = line[1];
		to_study = new int[N+1]; // to_study[i] = i번 과목을 공부하려면 해야할 선수과목의 수
		conn = new ArrayList[N+1]; // conn[i] = i번 과목의 선수과목 리스트
		after = new ArrayList[N+1]; // after[i] = i번 과목을 수료해야만 배울수 있는 과목의 리스트
		result = new int[N+1]; // 결과 리스트
		for(int i=1;i<=N;i++) {
			conn[i] = new ArrayList<Integer>();
			after[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			conn[line[1]].add(line[0]);
			after[line[0]].add(line[1]);
		}
		
		//배울수 있는 과목들이 들어가는 큐
		Queue<Node> study = new LinkedList<Node>();
		//필요한 선수과목의 수를 배열에 저장하고
		// 선구과목이 필요없는 과목들은 바로 큐에 넣는다.
		for(int i=1; i<=N;i++) {
			to_study[i] = conn[i].size();
			if(to_study[i] == 0) {
				study.add(new Node(i,1));
			}
		}
		//기본적으로 큐에는 배우기가 가능한 과목들이 들어가 있다.
		//과목을 하나씩 꺼내면서 "배우면"
		//이 과목을 선수과목으로 필요로하는 과목들의 필요 선수과목수를 감소시킨다.
		//to_study[큐에서 꺼낸 과목이 선수과목인 과목들]--;
		
		// to_study[~~~] == 0 이면 배우기가 가능하므로 큐에 삽입한다.
		while(!study.isEmpty()) {
			Node temp = study.poll();
			result[temp.idx] = temp.when;
			for(int i : after[temp.idx]) {
				to_study[i]--;
				if(to_study[i] == 0) {
					study.add(new Node(i,temp.when + 1));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			sb.append(result[i] + " ");
			
		}
		System.out.println(sb.toString());
		
	}
	static class Node {
		int idx;
		int when;
		public Node(int idx, int when) {
			super();
			this.idx = idx;
			this.when = when;
		}
		
	}
}
