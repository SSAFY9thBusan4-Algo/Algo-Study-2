package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

// 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산
// == 유니온 파인드

public class BOJ_1717_G5_집합의표현 {
	static int boss[];
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = line[0];
		int M = line[1];
		boss = new int[N+1];
		// N+1개의 집합 생성
		for(int i=0;i<=N;i++) {
			make_set(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		// line[0] 가 0 이면 합집합
		// line[0] 가 1 이면 최상위 보스를 찾아서 서로 비교하기
		for(int i=0;i<M;i++) {
			line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			switch(line[0]) {
				case 0 :
					union(line[1] , line[2]);
					break;
				case 1:
					if(find_boss(line[1]) == find_boss(line[2])) {
						sb.append("YES\n");
					}
					else {
						sb.append("NO\n");
					}
					break;
			}
		}
		System.out.println(sb.toString());
		
		
	}
	// 서로의 최종보스를 찾고
	// a의 촤종보스자리에 b의 최종보스를 넣는다.
	// 합집합 완성
	private static void union(int a, int b) {
		a = find_boss(a);
		b = find_boss(b);
		
		boss[a] = b;
	}
	// a 의 보스가 a 이다 => a 가 최종보스라는 뜻
	// 위의 a 가 나올떄까지 재귀해서 찾아간다.
	// 리턴할떄 그떄까지 찾아간 모든 경로의 보스를
	// 최종보스로 대입함으로써 다음에 같은경로를 탈떄는 
	// 올라가지 않고 바로 알 수 있다.
	private static int find_boss(int a) {
		if(a == boss[a]) {
			return a;
		}
		return boss[a] = find_boss(boss[a]);
	}
	private static void make_set(int i) {
		boss[i] = i;
	}
	
}