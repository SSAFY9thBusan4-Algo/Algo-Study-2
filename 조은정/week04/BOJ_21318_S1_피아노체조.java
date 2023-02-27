package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21318_S1_피아노체조 {
	private static BufferedReader in;
	private static StringTokenizer st;
	private static int[] sheet_array;
	
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new InputStreamReader(System.in));
		int N_sheet = Integer.parseInt(in.readLine());
		sheet_array = new int [N_sheet+1];
		
		//누적합 배열
		int[] cumulative = new int [N_sheet+1];
		int cnt = 0;
		st = new StringTokenizer(in.readLine());
		for(int i = 1; i <= N_sheet; i++) {
			sheet_array[i] = Integer.parseInt(st.nextToken());
			//array값을 받으면서 전 인덱스값보다 현재 인덱스값이 적을 경우 누적합에 추가
			if(sheet_array[i-1] > sheet_array[i]) {
				cnt++;
			}
			cumulative[i] = cnt;
		}
		int N_Question = Integer.parseInt(in.readLine());
		for(int i = 0; i < N_Question; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println((cumulative[end]-cumulative[start]));
		}
		
	}
}
