package ssafy.com.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662_G4_이중우선순위큐 {
	
	/**
	 * 45분
	 * 메모리 358052KB 시간 2304ms
	 * 처음 도전 1. 우선순위 큐 두개 쓰기 -> 시간 초과
	 * 도전 2. list로 정렬해서 최솟값 구할땐 인덱스0, 최댓값 구할 땐 인덱스 size()-1 로 구하기 -> 시간 초과
	 * 자료구조 검색하다가 트리맵 발견 !! 트리맵 사용해서 구현하기로 결정. (트리맵 정리 필요)
	 */
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int k = Integer.parseInt(in.readLine());
			
			//트리맵 사용. 트리맵 정리 필요!
			//키는 우선 순위 큐에 넣는 정수, 값은 정수가 몇 개 있는지
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			
			StringTokenizer st;
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(in.readLine());
				//명령 입력받음 I -> Q에 정수 삽입
				//D 1 최댓값 삭제 .. D -1 최솟값 삭제 
				char cmd = st.nextToken().charAt(0); //I인지 D인지 구하기
				switch(cmd) {
				case 'I':
					int num = Integer.parseInt(st.nextToken());
					//key가 num인 것이 있으면 해당 값에 +1 없으면 0 해서 put 
					map.put(num, map.getOrDefault(num, 0)+1); 
					break;
				case 'D':
					if(map.isEmpty()) continue;
					int cmdNo = Integer.parseInt(st.nextToken());
					//D -1 이면 최솟값 D 1 이면 최댓값 꺼내기!!
					int key = cmdNo==-1? map.firstKey() : map.lastKey();
					int cnt = map.get(key);
					//값이 1개면 해당 key 제거, 아니라면 개수를 -1 해준다.
					if(cnt==1) map.remove(key);
					else map.put(key, cnt-1);
				}
			}
			
			//비어있다면 EMPTY 아니라면 최댓값 최솟값 출력
			if(map.isEmpty()) sb.append("EMPTY\n");
			else sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
		}
		System.out.println(sb);
	}
	
}
