package week01.BOJ_1620_S4_나는야_포켓몬_마스터_이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_1620_S4_나는야_포켓몬_마스터_이다솜 {
	//name을 key로 갖는 map과, index를 key로 갖는 map 두 개를 만들어서,
	//입력으로 문제가 들어왔을 때 바로 값을 얻을 수 있도록 함.
	static Map<String, Integer> names = new HashMap<>();	//name을 key로 갖는 map
	static Map<Integer, String> indexes = new HashMap<>();	//index를 key로 갖는 map
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int nameN, problemN;
		
		//input N
		String[] lineArr = in.readLine().split(" ");
		nameN = Integer.parseInt(lineArr[0]);
		problemN = Integer.parseInt(lineArr[1]);
		
		//inputNames
		int idx = 1;
		while(nameN-- > 0) {
			String name = in.readLine();
			names.put(name, idx);
			indexes.put(idx++, name);
		}
		
		//problems
		while(problemN-- > 0) {
			String answer = "";
			String problem = in.readLine();
			//문자열이 정수인지 아닌지 판별하는 방법 : 예외처리 이용
			if (isInteger(problem)) {
				answer = indexes.get(Integer.parseInt(problem));
			}else {
				answer = names.get(problem) + ""; //""를 더하여 문자열로 바꿔줌
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
	
	private static boolean isInteger(String str) {
		try{
			Integer.parseInt(str);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
		
	}
}
