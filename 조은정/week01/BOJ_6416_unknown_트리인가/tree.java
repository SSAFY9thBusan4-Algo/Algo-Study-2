package alhorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class tree {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashSet<Integer> U = new HashSet<>();
		HashSet<Integer> V = new HashSet<>();
		boolean Tree = false;
		int i = 1;
		loop: while (true) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (a == -1 || b == -1) { // a,b가 -1인 경우 종료
					
					break loop;
				}
				if (a == 0 || b == 0) { // a,b가 0인 경우 트리인지 판별
					if (V.size() != 0) { // 정점이 0개인 트리는 트리
						int root = 0;
						Iterator<Integer> iter = U.iterator();
						while (iter.hasNext()) { // U set과 V set 비교
							if (!V.contains(iter.next()))
								root++; // U값이 V에 없으면 루트노드
						} // 하나도 들어오지 않는 U(루트노드)가 1개가 아니면 트리가 아님
						if (root != 1)
							Tree = true;
					}
					if (Tree) {
						System.out.println("Case " + i + " is not a tree.");
					} else {
						System.out.println("Case " + i + " is a tree.");
					}
					U = new HashSet<>(); // U,Vset 초기화
					V = new HashSet<>();
					i++;
					Tree = false;
					continue;
				}
				if (!V.add(b)) { // 들어오늘 V가 하나 이상일 경우 트리가 아님
					Tree = true;
				}
				U.add(a);
			}
		}
	}
}
