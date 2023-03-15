package BOJ_1913_S3_달팽이;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1913_S3_달팽이 {
	private static int cnt = 1 ;
	private static int vector;
	private static int N;
	private static int X;
	private static int[][] Array;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		X = sc.nextInt();
		Array = new int [N][N];
		int start = (int) Math.floor(N / 2); // 시작할 가운데 좌표찾기
		snail(start); 
		int a=0, b=0;
		for(int i = 0; i < N; i ++) { // 결과array출력
			for (int j = 0; j < N; j++) {
				sb.append(Array[i][j] + " ");
				if(Array[i][j] == X) { 
					a = i+1; 
					b = j+1;
				}
			}
			sb.append("\n");
		}
		sb.append(a + " " + b);
		System.out.println(sb);
	}	

	private static void snail(int start) {
		int[] dx = {0, 1, 0, -1}; //벡터 설정 
		int[] dy = {-1, 0, 1, 0};
		int x = start, y = start, nx = 0, ny = 0;
		int count = 1;
		Array[y][x] = cnt; //시작 좌표
		while(true) { 
			for(int i = 1; i <= 2; i++) { 
				for (int j = 1; j <= count; j++) {
					cnt++;
					nx = x + dx[vector]; //벡터값으로 다음 x,y좌표 설정
					ny = y + dy[vector];
					if(nx < 0 || nx >= N || ny < 0 || ny >=N || cnt > N * N) {
						//다음 위치가 배열 밖으로 벗어나거나 cnt가 N*N으로 달팽이를 다 만들었으면 return
						return;
					}
					Array[ny][nx] = cnt; //다음 위치로 갈 수 있기 때문에 다음 위치로 
					x = nx; //x,y set
					y = ny;
				}
				vector += 1; //벡터값을 증가시키면서 돌기
				vector %= 4;
			}
			count+= 1;
		}		
	}	
}
