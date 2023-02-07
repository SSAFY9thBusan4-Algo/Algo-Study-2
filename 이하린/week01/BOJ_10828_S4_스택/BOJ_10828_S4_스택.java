package dataStructure.arrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_10828_S4_스택 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); //명령의 수 N 입력 받음
		List<Integer> arr = new ArrayList<Integer>();
		
		for(int i = 0;i<N;i++) { //N번 반복
			
			String cmd = in.readLine(); //명령 입력 받기
			if (cmd.equals("pop")) { //명령이 pop이면
				if(arr.size() == 0) //스택이 비어있으면
					System.out.println(-1); //-1을 출력
				else { //스택이 비어있지 않으면
					System.out.println(arr.get(arr.size()-1)); //스택에서 가장 위에 있는 정수를 빼고 그 수를 출력
					arr.remove(arr.size()-1); //가장 최근에 들어온 정수 arrayList에서 제거
				}
			}
			else if(cmd.equals("size")) { //명령이 size면
				System.out.println(arr.size()); //arrayList에 들어있는 정수 개수 출력
			}
			else if(cmd.equals("empty")) {//명령이 empty면
				if(arr.size() == 0) //만약 스택이 비어있으면 
					System.out.println(1); //1 출력
				else //아니라면
					System.out.println(0); //0 출력
			}
			else if (cmd.equals("top")) { //명령이 top이라면
				if (arr.size() == 0) // 만약 스택이 비어있으면
					System.out.println(-1); //-1 출력
				else //아니라면
					System.out.println(arr.get(arr.size()-1)); //가장 최근에 들어온 정수 arrayList에서 출력
			}
			else if(cmd.substring(0, 4).equals("push")) { //명령이 push라면
				int num = Integer.parseInt(cmd.substring(5, cmd.length()));
				arr.add(num); //arrayList에 수 추가
			}
			
			
		}
		
	}

}
