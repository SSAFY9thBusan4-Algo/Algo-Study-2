package ssafy.com.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ_1935_S3_후위표기식2 {
	
	/**
	 * 20분
	 * 메모리 : 14556KB 시간 : 136ms
	 * 후위표기식으로 계산하려면 연산자를 찾고 해당 연산자 앞 두 피연산자를 해당 연산자로 계산해주면 된다
	 * 연산자를 찾으면 여태까지 나온 피연산자를 꺼내서 사용하면 되기 떄문에 스택 사용
	 * 또한 A B C ~ 알파벳에 대응하는 숫자를 꺼내와야 하기 때문에 
	 * map 자료구조를 사용하여 알파벳에 대응하는 숫자를 저장함.
	 */
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); //피연산자 갯수
		
		String str = in.readLine(); //후위 표기식 입력 받음.
		
		Stack<Double> stack = new Stack<Double>(); //나눗셈 계산 위해 Double로 받기
		
		//맵 자료구조
		Map<Character, Double> map = new HashMap<Character, Double>();
		
		for(int i=0; i<N; i++) { //맵 자료구조에 저장
			map.put((char)(65 + i), Double.parseDouble(in.readLine()));
		}
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			//c가 연산자이면 피연산자 2개를 pop 하고 계산한 결과를 스택에 push
			if(c=='*' || c== '+' || c=='/' || c=='-') {
				double a = stack.pop();
				double b = stack.pop();
				switch(c){
				case '+':
					stack.push(a + b);
					break;
				case '-':
					stack.push(b - a);
					break;
				case '*':
					stack.push(a*b);
					break;
				case '/':
					stack.push(b/a);
					break;
				}
			}
			else { //연산자가 아니라면 해당 알파벳에 대응하는 숫자 push 
				stack.push(map.get(c));
			}
		}
		
		// 마지막 값 -> 답
		double ans = stack.pop();
		
		// 소수점 둘째자리까지 출력 
		System.out.println(String.format("%.2f", ans));
		
	}
	
}
