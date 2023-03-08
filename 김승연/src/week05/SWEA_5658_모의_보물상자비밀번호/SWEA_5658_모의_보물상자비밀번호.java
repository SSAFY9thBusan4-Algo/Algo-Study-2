package week05.SWEA_5658_모의_보물상자비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SWEA_5658_모의_보물상자비밀번호 {

	static int N, K;
	static char[] input;
	static Set<String> nums = new HashSet<>();
	static List<Integer> numsLs = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			String[] line = in.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			K = Integer.parseInt(line[1]);
			
			input = in.readLine().toCharArray();
			
			// N/4자리 숫자 생성
			//N/4까지만 rotation 해도 됨. 나머지는 앞과 중복됨.
			for (int start = 0; start < N/4; start++) {//rotation
				makeNum(start);
			}
			
			// 그냥 십진수로 바꿔서 정렬하면 됨.
			changeTen();
			Collections.sort(numsLs, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			//K번쨰 숫자 추가.
			sb.append(numsLs.get(K - 1)).append("\n");
			
			//초기화 필수!!
			numsLs.clear();
			nums.clear();
		}
		System.out.println(sb);
	}
	
	private static void changeTen() {//16진수 -> 십진수
		for (String str : nums) {
			int myNum = 0;
			for (int i = 0; i < str.length(); i++) {
				char chr = str.charAt(i); // 가장 왼쪽 숫자부터
				int num = getDigit(chr);
				num *= Math.pow(16, str.length()-1 - i);
				
				myNum += num;
			}
			numsLs.add(myNum);
		}
	}
	
	private static int getDigit(char chr) { //16진수: char -> int
		if (chr - '0' >= 0 && chr - '0' <= 9) 
			return chr - '0';
		return chr - 'A' + 10;
	}
	
	private static void makeNum(int start) {
		int len = N / 4;
		for (int i = start; i < N; i+=len) { //다음 변
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < len; j++) { //한 변에서 만들어지는 숫자들
				int idx = (i + j) % N;
				sb.append(input[idx]);
			}
			nums.add(sb.toString());
		}
	}
}