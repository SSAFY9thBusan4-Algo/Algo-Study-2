package week01.BOJ_5618_B2_공약수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5618_B2_공약수 {
	private static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		int N = Integer.parseInt(in.readLine());
		String[] lineArr = in.readLine().split(" ");
		
		//string 입력값을 int로 바꿔 int 배열에 넣음
		nums = new int[N];
		int i = 0;
		for (String numStr : lineArr) {
			nums[i++] = Integer.parseInt(numStr);
		}
		
		//logic
		//n을 1부터 입력값 중 가장 최솟값까지 증가시키며, 공약수를 찾음
		for (int n = 1; n <= getMinNum(); n++) {
			boolean isDivisor = true;	//n이 공약수인지
			for (int num : nums) {		//모든 num에 의해 나눠지면 공약수
				if (num % n != 0) {
					isDivisor = false;	//기본값을 true로 주고 하나라도 나눠지지 않으면 false
					break;
				}
			}
			if (isDivisor) System.out.println(n);
		}
	}
	
	public static int getMinNum() { 		//입력받은 수 중 가장 최솟값을 찾는 함수
		int minVal = Integer.MAX_VALUE;		// Integer 가장 큰 값
		for (int num : nums) {
			if (minVal > num) minVal = num;
		}
		return minVal;
	}
}
