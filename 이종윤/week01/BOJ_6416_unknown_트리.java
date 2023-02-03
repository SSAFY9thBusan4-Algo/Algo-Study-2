package week01;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ_6416_unknown_트리 {
	static int root; // 최상위 노트
	static boolean isTree; // 트리 구조 (=자식노드를 가리키는 부모노드가 하나임)를 만족하는지 여부

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));

//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스 당 입력 개수를 모르고 중간중간 공백이 많아 정수 입력을 받기 용이한 Scanner 사용
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		// 트리 구조를 저장할 해시맵
		// 트리 구조에서 자식노드를 가리키는 부모노드는 하나이기 때문에 자식을 key, 부모를 value 쌍으로 저장
		HashMap<Integer, Integer> tree = new HashMap<>();

		int testcase = 1;
		isTree = true;
		root = -1;

		while (true) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			//입력의 끝
			if (u == -1 && v == -1)
				break;

			// 테스트케이스의 끝
			if (u == 0 && v == 0) {
				// 모든 자식노드 에 대해서 자식을 가리키는 부모가 하나인 경우
				if (isTree)
					// 루트 노드 탐색
					tree.forEach((key, value) -> {
						// 트리 구조를 만족하기 위해서는 최상위 노드(=자신을 가리키는 노드가 없음)가 하나뿐이어야함
						// 모든 부모노드에 대해서 해당 노드의 부모가 없는 노드 탐색
						if (!tree.containsKey(value)) {
							// root가 -1이면 최상위 노드를 찾지 못한 상태
							// 현재 찾은 최상위 노드가 이전에 찾은 최상위 노드와 다른 경우 최상위 노드가 2개이므로 트리구조가 아님 
							if (root != -1 && root != value)
								isTree = false;
							else
								root = value;
						}
					});

				// 트리구조를 만족하는 경우(노드가 없는 경우도 트리구조로 인정) 
				if (isTree && (root != -1 || tree.size() == 0))
					sb.append("Case " + testcase++ + " is a tree.\n");
				// 트리구조를 만족하지 않는 경우
				else
					sb.append("Case " + testcase++ + " is not a tree.\n");

				// 트리 초기화 후 다음 테스트케이스 진행
				tree.clear();
				isTree = true;
				root = -1;
				continue;
			}

			// 해당 자식노드를 가리키는 부모노드가 없을 경우
			// 해시맵에 트리 정보를 저장
			if (!tree.containsKey(v))
				tree.put(v, u);
			// 해당 자식노드를 가리키는 부모노드가 이미 있는 경우
			// 자식을 가리키는 부모가 둘 이상이므로 트리구조가 아님
			else
				isTree = false;
		}
		System.out.println(sb);
	}
}