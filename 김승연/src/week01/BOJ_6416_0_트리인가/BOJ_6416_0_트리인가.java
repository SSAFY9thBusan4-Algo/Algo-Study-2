package week01.BOJ_6416_0_트리인가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BOJ_6416_0_트리인가 {
	private static Map<Integer, List<Integer>> tree = new HashMap<>();
	//입력받을 node를 저장할 map
	//key : node name
	//value : key node의 adjacent node list
	private static Map<Integer, Integer> isRoot = new HashMap<>();	//root 찾는 map
	private static Map<Integer, Integer> visited = new HashMap<>();	//dfs 위한 map
	
	private static boolean isEnd = false;			//입력의 종료
	private static boolean isTestcaseEnd = false;	//테케의 종료
	private static int root;						//tree의 루트
	private static boolean isTree = true;			//트리인가? 기본값을 true로 설정하고 조건을 어기면 false
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
	
		int tc = 1;	//test case num
		while(!isEnd) {							//입력이 끝나지 않을때동안 테케 하나 당 input
			while (!isTestcaseEnd && !isEnd){	//하나의 테케 입력
				int node = sc.nextInt();
				int adj = sc.nextInt();
				addNode(node, adj);				//정수 두 개를 받아서 tree에 노드 추가
			}
			if (isEnd) break;
			
			/*
			 * 트리의 조건
			 * 0. 노드가 아무것도 없어도 tree
			 * 1. 노드가 있다면
			 * 	1.1 루트 존재
			 * 	1.2 루트에서 다른 '모든' 노드로 가는 유일한 하나의 길 존재
			 */
			if (!tree.isEmpty() && haveRoot()) {	// 0. 트리가 비어있으면 바로 isTree로 출력
													// 1.1 루트 존재 확인
				//방문한 노드 확인하기 위한 visited. isRoot에 노드들 다 있어서 가져와서 씀. val은 0으로 초기화
				for (int k : isRoot.keySet()) visited.put(k, 0);
				
				//1.2 root부터 dfs 수행하여 방문노드 체크
				for (int adjNode : tree.get(root)) {
					dfs(adjNode);
				}
				//1.2 검증
				if (!isConnectAll()) isTree = false;
			}
			
			//출력
			if (isTree)	sb.append("Case " + tc + " is a tree.\n");
			else 		sb.append("Case " + tc + " is not a tree.\n");
			
			//초기화!! - 필수..
			clear();
			tc++;
		}
		System.out.println(sb);
	}
	
	private static void addNode(int inNode, int inAdjNode) {
		if (inNode == 0 && inAdjNode == 0) { //테케의 끝에는 '0 0' 입력
			isTestcaseEnd = true;
			return;
		}
		else if (inNode < 0 && inAdjNode < 0) { //테케의 끝에는 음수 입력
			isEnd = true;
			isTestcaseEnd = true; //이걸 해야 끝남
			return;
		}

		//key가 이미 존재: inKey에 해당하는 노드를 tree에서 가져와서 list에 inVal 추가
		if (tree.keySet().contains(inNode)) {
			tree.get(inNode).add(inAdjNode);
		}
		//key가 존재하지 않음 : inKey와 함께 List를 생성해서 tree에 넣어줌
		else {
			List<Integer> adjNodes = new ArrayList<>();
			adjNodes.add(inAdjNode);
			tree.put(inNode, adjNodes);
		}
	}
	
	private static Map<Integer, Integer> getAllNodeIndir(){
		//tree를 돌면서 모든 노드 추가하고,
		//key에 해당하는 노드에 들어오는 간선이 있으면 val에 1, 없으면 val에 0 설정
		
		Map<Integer, Integer> allNode = new HashMap<>();
		for (int node : tree.keySet()) {
			if (!allNode.containsKey(node)) 
				allNode.put(node, 0);
			
			for (int adjNode : tree.get(node)) {
				if (allNode.containsKey(adjNode)) 
					allNode.replace(adjNode, 1);
				else 
					allNode.put(adjNode, 1);
			}
		}
		return allNode;
		
	}
	
	private static boolean haveRoot() {
		isRoot = getAllNodeIndir();
		
		int rootCnt = 0;					//root라고 판별되는 노드의 수
		for (int node : isRoot.keySet()) {
			if (isRoot.get(node) == 0) {	//isRoot의 val 값이 0 인 노드가 root
				root = node;
				rootCnt++;
			}
		}
		if (rootCnt != 1) {	//root라고 판별되는 노드가 1개 이상 또는 없으면 트리가 아님
			isTree = false;
			return false;
		}
		else return true;
	}
	
	private static void dfs(int node) {
		if (!isTree) return;
		
		if (visited.get(node) != 0) { 			//이미 방문한 노드 - tree 아님. 리턴
			isTree = false;
			return;
		}
		visited.replace(node, 1);				//방문 설정
		
		if (!tree.containsKey(node)) return; 	//
		for (int adjNode : tree.get(node)) {	//인접한 노드 방문
			dfs(adjNode);
		}
	}
	
	private static boolean isConnectAll() {
		//dfs를 수행한 후 root 노드 외에 모든 노드에 방문했으면 tree.
		for (int node : visited.keySet()) {
			if (node == root) continue;
			if (visited.get(node) == 0) return false;
		}
		return true;
	}
	
	private static void clear() {
		tree.clear();
		isRoot.clear();
		visited.clear();
		
		isTestcaseEnd = false;
		isTree = true;
	}
}