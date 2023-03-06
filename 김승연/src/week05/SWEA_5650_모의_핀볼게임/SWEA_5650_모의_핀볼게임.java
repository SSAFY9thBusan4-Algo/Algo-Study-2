package week05.SWEA_5650_모의_핀볼게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5650_모의_핀볼게임 {

	static int N;
	static int[][] map;
	static int startR, startC;
	static int maxScore = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(in.readLine().trim()); //입력 테스트 값에 공백 제거(BufferedReader로 읽을 때)
		int tc = 1;
		while(T-- > 0) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine().trim());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//logic
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) { //모든 빈공간에 대해 핀볼을 두고 게임 시작
						startR = i;
						startC = j;
						
						for (int sta = 0; sta < 4; sta++) { //모든 status(0~3)에 대해 게임 수행
							status = sta;
							score = 0;
							game(i, j);
							maxScore = Math.max(maxScore, score); //게임을 수행할 떄마다 점수를 최대로 갱신
						}
					}
				}
			}
			sb.append(maxScore).append("\n");
			maxScore = 0;
			tc++;
		}
		System.out.println(sb);
	}

	/*
	 * 블록(1~5), 벽 -> 방향전환
	 * 웜홀(6~10) -> 이동
	 * 블랙홀(-1), 초기위치 -> 종료
	 */
	static int[] dr = {1, -1, 0, 0}; //하, 상, 우, 좌
	static int[] dc = {0, 0, 1, -1};
	static int status = 0;
	static int score = 0;
	private static void game(int r, int c) {
		boolean isEnd = false;
		
		while(!isEnd) { //게임 시뮬!
			int nr = r + dr[status]; //status에 따른 방향
			int nc = c + dc[status];
			
			//이동했을 떄 무엇을 만나느냐에 따라 changeStatus를 통해 status 값을 조정하여 방향을 전환함.
			//여기서 문제를 잘 읽고 조건에 따라 정확하게 처리해줘야 함!!!
			if (nr < 0 || nr >= N || nc  < 0 || nc >= N) {
				//벽 : 점수증가, 방향전환
				score++;
				if (status == 0 || status == 2) changeStatus(1);
				else changeStatus(3);
			}
			else if (map[nr][nc] >= 1 && map[nr][nc] <= 5 ) {
				//블록 : 점수증가, 방향 전환
				score++;
				switch(map[nr][nc]) {
				case 1:
					if (status == 1) changeStatus(3);
					else if (status == 2) changeStatus(1);
					else changeStatus(2);
					break;
				case 2:
					changeStatus(1);
					break;
				case 3:
					if (status == 0) changeStatus(1);
					else if (status == 3) changeStatus(3);
					else changeStatus(2);
					break;
				case 4:
					changeStatus(3);
					break;
				case 5:
					if (status == 1) changeStatus(3);
					else if (status == 2) changeStatus(1);
					else if (status == 0) changeStatus(1);
					else if (status == 3) changeStatus(3);
					break;
				}
				
			}
			else if (map[nr][nc] >= 6 && map[nr][nc] <= 10) {
				//웜홀 : 같은 번호 찾아서 이동
				boolean isFound = false;
				for (int i = 0; i < N; i++) {
					if (isFound) break; //찾으면 끝내줌
					for (int j = 0; j < N; j++) {
						if (!(i == nr && j == nc) && map[i][j] == map[nr][nc]) {
							nr = i;
							nc = j;
							isFound = true;
							break;
						}
					}
				}
			}
			else if (map[nr][nc] == -1 || (nr == startR && nc == startC)) {
				//시작위치나 블랙홀: 게임 종료
				isEnd = true;
			}
			r = nr;
			c = nc;
			
		}
	}
	private static int changeStatus(int diff) {
		status = (status + diff) % 4;
		return status;
	}
}
