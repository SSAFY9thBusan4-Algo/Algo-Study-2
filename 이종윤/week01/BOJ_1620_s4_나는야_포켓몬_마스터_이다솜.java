package week01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1620_s4_나는야_포켓몬_마스터_이다솜 {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] s = in.readLine().split(" ");
		
		// <도감번호, 이름> 쌍으로 된 도감
		HashMap<Integer, String> dek = new HashMap<>();
		// <이름, 도감번호> 쌍으로 된 도감
		HashMap<String, Integer> dek2 = new HashMap<>();
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		// 각각의 입력을 두 도감에 각각 저장
		for (int i = 1; i <= n; i++) {
			String pokemon = in.readLine();
			dek.put(i, pokemon); // 도감 번호가 key, 이름이 value
			dek2.put(pokemon, i); // 이름이 key, 도감 번호가 value
		}
		
		for (int i = 0; i < m; i++) {
			String pokemon = in.readLine();
			try {
				// 입력이 숫자일 경우 해당 도감번호로 도감 검색, 포켓몬의 이름을 출력
				// 입력이 문자열일 경우 Integer.parseInt()에서 에러가 발생, catch 실행
				int num = Integer.parseInt(pokemon);
				sb.append(dek.get(num)+"\n");
			} catch (Exception e) {
				// 입력이 문자열일 경우 이름으로 도감 검색, 포켓몬의 도감 번호를 출력
				sb.append(dek2.get(pokemon)+"\n");
			}
		}

		System.out.println(sb);
	}
}