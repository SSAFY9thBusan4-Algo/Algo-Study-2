package alhorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S3 {
	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String[] _string = read.readLine().split(" ");
		int N = Integer.parseInt(_string[0]); // N 
		int M = Integer.parseInt(_string[1]); // M
		HashMap<String,String> map = new HashMap<String,String>(N); // index와 N리스트 정보를 저장할 hashmap생성
		for (int i = 0; i < N; i++) { //hashmap은 value값만 얻어올 수 있으므로 index와 value전부 map에 추가
			String pocketmon = read.readLine();
			map.put(Integer.toString(i + 1), pocketmon); 
			map.put(pocketmon,Integer.toString(i + 1));	
		}
		for (int j = 0; j < M; j++) {
			System.out.println(map.get(read.readLine())); //읽어온 값에 대한 value값을 map에서 출력
		}		
	}	
}