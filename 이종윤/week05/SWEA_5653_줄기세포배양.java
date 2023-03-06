import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SWEA_5653_줄기세포배양 {
	static StringBuilder sb = new StringBuilder();
	static int N, M, K;
	static Cell[][] grid;
	static List<Cell> cells;

	public static void main(String args[]) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] s;

			s = in.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			K = Integer.parseInt(s[2]);

			// 세포들을 2차원 배열로 관리
			// N,M이 50 이내이고 K가 최대 300이므로 세포는 최대 350x350 크기의 격자 내에서 번식시킬 수 있다.
			grid = new Cell[351][351];

			// 현재 생존한 세포들을 저장할 리스트
			cells = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				s = in.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					int h = Integer.parseInt(s[j]);
					if (h > 0) {
						Cell c = new Cell(151 + i, 151 + j, h);
						grid[151 + i][151 + j] = c;
						cells.add(c);
					}
				}
			}

			// K번 시뮬레이션 진행
			for (int i = 1; i <= K; i++)
				simul();

			// 생존한 세포의 수 = 리스트에 저장된 세포의 수
			int ans = cells.size();

			sb.append("#" + test_case + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	static void simul() {
		// cells 리스트는 기존의 세포들이 저장되어 있고
		// newcells는 활동 후 생존한 세포 + 새로 번식된 세포들이 저장됨
		List<Cell> newcells = new ArrayList<>();
		for (Cell c : cells)
			// Cell.active 메소드는 세포의 활동 후 생존 여부를 리턴함
			if (!c.active(newcells))
				// 생존한 경우 newcells에 추가
				newcells.add(c);
		// 세포 정보 최신화
		cells = newcells;
	}

	// x,y는 배양 용기에서의 위치
	// health는 생명력
	// t는 상태가 변화하기 까지 남은 시간
	// active는 활성 상태 여부
	static class Cell {
		int x, y;
		int health;
		int t;
		boolean active;

		public Cell(int x, int y, int health) {
			this.x = x;
			this.y = y;
			this.health = health;
			t = health;
		}

		boolean active(List<Cell> newcells) {
			// 활성 상태가 된 후 첫 번째 활동 시 번식한다.
			if (active && t == health)
				spread(newcells);

			t--;
			if (t == 0) {
				// 활성 상태에서 카운트가 다 된 경우 죽은 상태가 되므로 참을 리턴(=cells 리스트에서 제거됨)
				if (active)
					return true;
				// 비활성 상태에서 카운트가 다 된 경우 활성 상태가 되고 카운트 초기화
				t = health;
				active = true;
			}
			return false;
		}

		void spread(List<Cell> newcells) {
			// 4방 탐색을 위한 배열
			int[] dx = { -1, 0, 1, 0 };
			int[] dy = { 0, -1, 0, 1 };

			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 해당 공간이 비어있다면 새로운 세포 생성
				if (grid[nx][ny] == null) {
					Cell c = new Cell(nx, ny, health);
					grid[nx][ny] = c;
					newcells.add(c);
				} else {
					Cell target = grid[nx][ny];

					// 해당 공간의 세포가 이번에 생성된 세포가 아니라면 무시
					// 죽은 세포는 활성 상태에서 죽어있음
					// cells에는 기존의 세포만 있기 때문에 새로 생성된 세포는 포함되어 있지 않음
					if (target.active || cells.contains(target))
						continue;

					// 이번에 생성된 세포라면 생명력이 더 강한 쪽이 남음
					if (target.health < this.health) {
						target.health = this.health;
						target.t = this.t;
					}
				}
			}
		}
	}
}