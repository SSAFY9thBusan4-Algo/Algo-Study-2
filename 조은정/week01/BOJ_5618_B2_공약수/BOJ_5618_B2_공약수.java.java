package alhorithm;

import java.util.Scanner;

public class common_divisor {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Min = Integer.MAX_VALUE; // 최솟값을 구하기 위해 int형 가장 큰 수 설정
		int[] array = new int[N];
		for (int i = 0; i < N; i++) { // array배열에 N개의 숫자 대입 
			array[i] = sc.nextInt();
			if (Min > array[i]) { // 입력값이 지금까지의 최솟값보다 작으면 입력값이 최솟값
				Min = array[i];
			}
		}
		for (int j = 1; j <= Min; j ++) { // 공약수 찾기
			boolean result = true;
			for (int num : array) { // array[i]값으로 나누어지지 않으면 false
				if(num % j != 0){
					result = false;
					break;
				}
			}// 모든 array[i]값으로 나누어지면 공약수 (true)
			if(result) { //result = true이면 (공약수이면)
				System.out.println(j); //출력
			}
		}		
	}
}
