package dataStructure.arrayList;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_5618_B2_공약수 {
	
public static void main(String[] args) throws Exception {
		
		
		//System.setIn(new FileInputStream("input.txt"));		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		/**
		 * 자연수 n개 입력받음.
		 */
		int n = Integer.parseInt(in.readLine());
		
		/**
		 * n개의 공약수를 입력받는다.
		 * int 배열 num은 n의 크기와 상관없이 크기를 3으로 지정해서 생성
		 * min은 입력받은 수 중에서 제일 작은 수를 찾기위해 생성한 변수
		 */
		String[] input = in.readLine().split(" ");
		int[] num = new int[3];
		int min = Integer.MAX_VALUE;
		
		/**
		 * 입력받은 배열 input의 크기만큼 for문 반복
		 * String -> int로 타입 변환 후
		 * 제일 작은 수인 min을 찾음.
		 * 공약수를 찾는 계산을 하기 위해서 만약 n이 2라면 (입력받은 수가 2개라면), num[2]에 0을 대입해준다. (조건문에 영향 없음)
		 */
		for(int i =0;i<input.length;i++) {
			num[i] = Integer.parseInt(input[i]);
			if (min > num[i])
				min = num[i];
		}
		if (n==2) num[2] = 0;
		
		/**
		 * for문으로 i는 1부터 min까지 반복한다.
		 * num[0], num[1], num[2]가 모두 i로 나누었을 때 나머지가 0이라면 i는 n개의 수의 공약수이므로 바로 i를 출력한다.
		 */
		for(int i=1;i<=min;i++) {
			if (num[0] % i == 0 && num[1] % i == 0 && num[2] % i == 0)
				System.out.println(i);
		}
		
	}
}
