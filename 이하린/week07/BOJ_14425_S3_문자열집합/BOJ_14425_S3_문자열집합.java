package ssafy.com.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14425_S3_문자열집합 {
	
	// 10분
	// 메모리 30776KB 시간 2632ms
	// 이렇게 풀면 안될 것 같은데 .. 풀려서 일단 풀었다 ... 
	// 다른 분들은 어떻게 풀었는 지 검색 필수 !! 
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] S = new String[N];
		
		for(int i=0; i<N; i++) {
			S[i] = in.readLine(); // 문자열 집합 S에 문자열 정보 추가
		}
		
		int cnt = 0; //cnt 저장 변수 
		
		//M개의 문자열 .. 
		for(int i=0; i<M; i++) {
			String str = in.readLine(); //M번 동안 문자열 받아옴 
			for(int j=0; j<N; j++) {// S 집합과 비교
				if(str.equals(S[j])) { //만약 S 집합의 원소와 같다면 
					cnt++; //cnt를 증가시키고 중단시킨다.
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
}
