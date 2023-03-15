package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_G5_집합의표현 {
	
	/**
	 * 메모리 46996KB 시간 456ms
	 * 수업시간에 배웠던 코드를 쓰니까 바로 풀렸다.
	 */
	
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N; //원소의 총 개수
	private static int[] parents; //각 원소의 부모 
	
	//집합 생성 
	private static void makeSet() {
		parents = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	//a의 집합 찾기 (a 대표자 찾기)
	private static int findSet(int a) {
		if(parents[a] == a) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]);
	}
	
	
	//a, b union
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
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken()); //집합의 개수 N+1, 0 ~ N 까지 서로소 집합 생성 
		
		makeSet(); //집합 생성 
		
		int M = Integer.parseInt(st.nextToken()); //명령 개수
		
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(in.readLine());
			
			//0이면 집합 합치기(union), 1이면 같은 집합인지 확인하기
			int cmd = Integer.parseInt(st.nextToken()); 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			switch (cmd) {
			case 0:
				union(a, b);
				break;
			case 1:
				// a와 b가 같은 집합에 포함되어 있으면 YES, 아니면 NO 
				if(findSet(a) == findSet(b)) sb.append("YES").append('\n');
				else sb.append("NO").append('\n');
				break;
			}
			
		}
		
		System.out.println(sb);
	}
	
	
}