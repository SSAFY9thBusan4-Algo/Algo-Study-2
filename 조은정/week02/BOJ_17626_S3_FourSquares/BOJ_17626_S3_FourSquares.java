package BOJ_17626_S3_FourSquares;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17626_S3_FourSquares {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(in.readLine()); //입력받을 N값 0 <= N <= 50,000
		System.out.println(FourSquares(N)); 
	}
	
	private static int FourSquares(int N) { //제곱근 합 판별
		int[] squares_Array = new int [N+1]; //
		squares_Array[0] = 0;
		squares_Array[1] = 1;
		for(int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE; //원래 배열 값 초기화
			for(int j = 1; j*j <= i; j++) {
				min = Math.min(min, squares_Array[i-j*j] + 1); 
				// i보다 작은 제곱근을 모두 판별해서 최솟값으로 설정
				squares_Array[i] = min;
			}			
		}
		return squares_Array[N];
	}
}
