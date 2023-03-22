package week07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_7662_g4_이중우선순위큐 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static TreeMap<Integer, Integer> map;
	static int N;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {

			N = Integer.parseInt(in.readLine());
			String[] s;
			// 최대, 최소 key 값을 쉽게 접근할 수 있는 TreeMap 자료구조 사용
			// 입력된 정수를 key, 입력된 횟수를 value로 저장함
			map = new TreeMap<>();

			for (int i = 0; i < N; i++) {
				s = in.readLine().split(" ");
				switch (s[0]) {
				case "I":
					int num = Integer.parseInt(s[1]);
					// 해당 key 값으로 이미 만들어진 쌍이 있으면 value 값을 1 증가
					// 쌍이 없으면 value를 1로 생성
					map.put(num, map.getOrDefault(num, 0) + 1);
					break;
				case "D":
					// TreeMap이 비어있으면 동작하지 않음
					if (!map.isEmpty()) {
						if (s[1].equals("1")) {
							// 최대값 key를 통해 최대값 제거
							int key = map.lastKey();
							int value = map.get(key);

							// 최대값이 둘 이상인 경우 value만 감소, 하나인 경우 해당 key 삭제
							if (value == 1)
								map.remove(key);
							else
								map.replace(key, value - 1);
						} else {
							// 최소값 key를 통해 최소값 제거
							int key = map.firstKey();
							int value = map.get(key);

							// 최소값이 둘 이상인 경우 value만 감소, 하나인 경우 해당 key 삭제
							if (value == 1)
								map.remove(key);
							else
								map.replace(key, value - 1);
						}
					}
					break;
				}
			}
			// TreeMap이 비어있으면 EMPTY 출력
			// 비어있지 않으면 최대, 최소값 출력
			if (map.isEmpty())
				sb.append("EMPTY\n");
			else
				sb.append(map.lastKey() + " " + map.firstKey() + "\n");
		}
		System.out.println(sb);
	}
}
