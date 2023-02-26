package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_G5_2447_별찍기10 {
	private static int N;
	private static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		//N * N char배열 모두 *로 채우기
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], '*');
		}
		
		//분할정복 함수
		cut(0, 0, N, 1);

		//출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void cut(int row, int column, int size, int cnt) {
		//가운데 섹션일 경우
		if (cnt == 5) {
			//공백 ' ' 으로 변경
			for (int i = row; i < row + size; i++) {
				for (int j = column; j < column + size; j++) {
					map[i][j] = ' ';
				}
			}
		}
		//종료조건
		else if (size >= 3) {
			//섹션 나누기 (9등분)
			int divide = size / 3;
			cut(row, column, divide, 1);
			cut(row, column + divide, divide, 2);
			cut(row, column + 2 * divide, divide, 3);
			cut(row + divide, column, divide, 4);
			cut(row + divide, column + divide, divide, 5);
			cut(row + divide, column + 2 * divide, divide, 6);
			cut(row + 2 * divide, column, divide, 7);
			cut(row + 2 * divide, column + divide, divide, 8);
			cut(row + 2 * divide, column + 2 * divide, divide, 9);
		}
		if (size < 3)	return;
	}
}