import java.util.Scanner;

public class Main {
	static char[][] starBoard;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 별을 찍을 char 이중배열 starboard 선언
		starBoard = new char[N][N];
    
    //배열에 별 찍기
		sol(0,0,N);
		
    //배열 내용물을 빠르게 출력하기 위해 StringBuilder에 넣어서 출력하기
		StringBuilder sb = new StringBuilder();
    
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(starBoard[i][j] );
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
  // 배열에 별을 찍는 함수
  // 분할정복으로 커다란 배열을 9등분 쪼개서 처리한다.
	private static void sol(int row , int col , int size) {
		int third = size/3;
    
    // 가장 작은 부분인 가운데가 빈 3*3 별이 만들어 진다.
		if(third == 1) {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					starBoard[row+i][col+j] = '*';
				}
			}
			starBoard[row+1][col+1] = ' ';
			return;
		}
    
		sol(row , col , third);
    
    // 위에서 왼쪽윗 부분의 별이 찍힌뒤에
    // 여기서 그부분을 그대로 복사해서
    // 9등분된 나머지 부분을 채워준다.
    // 단 중앙부분은 공백으로 채워준다.
		for(int i=0; i<third;i++) {
			for(int j=0;j<third;j++) {
				starBoard[row+i][col + third + j] = starBoard[row+i][col+j];
				starBoard[row+i][col + 2*third + j] = starBoard[row+i][col+j];
				starBoard[row+i + third][col + j] = starBoard[row+i][col+j];
				starBoard[row+i + third][col + third + j] = ' ';
				starBoard[row+i + third][col + 2*third + j] = starBoard[row+i][col+j];
				starBoard[row+i + 2*third][col + j] = starBoard[row+i][col+j];
				starBoard[row+i + 2*third][col + third + j] = starBoard[row+i][col+j];
				starBoard[row+i + 2*third][col + 2*third + j] = starBoard[row+i][col+j];
			}
		}
	}
}
