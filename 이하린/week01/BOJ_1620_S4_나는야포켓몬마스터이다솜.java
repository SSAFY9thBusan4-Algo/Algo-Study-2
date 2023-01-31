package dataStructure.arrayList;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BOJ_1620_S4_나는야포켓몬마스터이다솜 {
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("input.txt"));
		
		/**
		 * 도감에 수록되어 있는 포켓몬의 개수 N과 맞춰야 하는 문제 개수 M 입력 받기
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		/**
		 * 도감에서 바로 찾을 수 있도록 HashMap과 ArrayList 생성
		 * String(Name)으로 찾을 땐 String Key로 바로 접근할 수 있게끔 HashMap으로 생성했고,
		 * Integer(Num)으로 찾을 땐 ArrayList의 인덱스로 접근이 가능하므로 ArrayList로 생성
		 */
		HashMap<String, Integer> pocketName = new HashMap<String, Integer>();
		List<String> pocketNum = new ArrayList<String>();
		
		/**
		 * N번 돌면서 포켓몬 도감에 각각 정보 등록
		 */
		for(int i=1;i<=N;i++) {
			String pocketmon = in.readLine();
			pocketName.put(pocketmon, i);
			pocketNum.add(pocketmon);
		}
		
		/**
		 * 한 번 찾을 때 반복문으로 도감을 싹 다 탐색하면 시간 초과가 뜬다.
		 * 그렇기 때문에 바로 원하는 값을 찾을 수 있도록 get 함수 사용
		 * 포켓몬의 이름은 첫글자만 대문자라는 조건이 있었기 때문에 해당 조건을 사용하여 입력이 Name이라는 것을 파악한다.
		 */
		for(int i=0;i<M;i++) {
			String question = in.readLine();
			char firstCh = question.charAt(0);
			
			if (('A' <= firstCh && firstCh <= 'Z') /*|| ('a' <= firstCh && firstCh <= 'z')*/) {
				System.out.println(pocketName.get(question));
			}
			else {
				System.out.println(pocketNum.get(Integer.parseInt(question)-1));
			}
			
		}
		
	}
	
 }
