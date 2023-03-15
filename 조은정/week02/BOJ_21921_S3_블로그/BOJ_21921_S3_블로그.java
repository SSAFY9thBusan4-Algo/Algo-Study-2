package BOJ_21921_S3_블로그;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_21921_S3_블로그 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] _string = in.readLine().split(" ");
		int N = Integer.parseInt(_string[0]);
		int X = Integer.parseInt(_string[1]);
		int[] array = new int [N+1]; //index 헷갈리지 않게 X+1 크기 배열 생성
		_string = in.readLine().split(" ");
		array[0] = 0;
		for(int i = 1; i <= N; i++) { //index[1]부터 배열값 넣기
			array[i] = Integer.parseInt(_string[i-1]);
		}
		blog(X,N,array);
		
	}
	
	private static void blog(int X, int N, int[] array) {
		int end = N - X;
		int[] sum_array = new int [end+1]; //N개의 합이 담겨있는 배열 생성 (X-N+1개)
		int sum = 0;
		int cnt = 1;
		for(int i = 1; i <= X; i++) {
			sum += array[i]; // 처음 N개의 합
		}
		sum_array[0] = sum;	 // N개의 합 sum_array에 추가
		for(int i = 1; i <= end; i++) { //슬라이딩 윈도우
			sum -= array[i];	//제일 앞 array값은 빼고
			sum += array[X+i];  //다음 array값 추가 
			sum_array[i] = sum;	//다음 N개의 합 sum_array에 추가
		}
		Arrays.sort(sum_array); //sum_array배열 sort
		int max = sum_array[end]; //sort되었으므로 가장 마지막 index가 최댓값
		int i = 0;
		while (max != 0 && end-i > 0 && (sum_array[end-i] == sum_array[end-i-1])) {
			// 최댓값 갯수를 구하기 위해 sort된 배열 끝에서부터 앞으로 가면서 비교
			cnt++;
			i++;
		}
		if(max == 0)
			System.out.println("SAD"); // max값이 0이면 (방문자 수 전부 0) SAD
		else {
			System.out.println(max); //아니면 max값과 
			System.out.println(cnt); //max값 개수 출력
		}
	}
}
