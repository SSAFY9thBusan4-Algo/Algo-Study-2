package harin.java.boj;

//import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_6416_unknown_트리인가  {

public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("input.txt"));
		
		 // 처음엔 BufferedReader 로 풀었는데 숫자간 공백 입력 처리하는게 어려워서 Scanner로 바꾸었다.
		Scanner sc = new Scanner(System.in);
		// 노드마다 들어오는 간선의 개수를 기록하는 HashMap 생성, 키 : 노드 번호 값 : 들어오는 간선의 수
		HashMap<Integer, Integer> edge = new HashMap<Integer, Integer>();
		int treeCnt = 1; //TC 카운트 위한 변

		while(true) { //두 개의 음의 정수가 주어질 때 까지 반복 
			int root = 0; //루트 노드의 수를 세기위한 변수 
			boolean isTree = true; //tree인지 아닌지 확인 위한 변수 
			
			//u, v 입력 
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			if (u<0 && v<0) return; //입력 받은 수가 음의 정수이면 프로그램 종료 
			else if (u == 0 & v == 0) { // 입력 받은 수가 0  이라면 
				for (Integer key : edge.keySet()) { 
					if(edge.get(key) == 0) root++; //들어오는 간선의 개수가 0개라면 루트 노드 개수 추가 
					else if(edge.get(key) > 1) isTree = false; //만약 들어오는 간선의 개수가 1개 초과라면 트리 아님 
				}
				if (root != 1) isTree = false; //루트 노드의 개수가 1개가 아닐 시 트리 아님 
				/**
				 * 트리를 만족하는 자료구조는 비어있을 수 있다고 했으니 
				 * edge.isEmplty가 true 라면 트리임. 
				 */
				if (edge.isEmpty()) isTree = true;
				
				
				if (isTree) System.out.printf("Case %d is a tree.%n", treeCnt++);
				else{
					System.out.printf("Case %d is not a tree.%n", treeCnt++);
				}
				
				edge.clear(); //edge 초기화 
			}
			else { // 입력이 0도 아니고 음의 정수도 아닐때 edge에 노드와 들어오는 간선 개수 추가하기 
				edge.put(u, edge.getOrDefault(u, 0));
				edge.put(v, edge.getOrDefault(v, 0) + 1);
			}
		}
	}
	
}
