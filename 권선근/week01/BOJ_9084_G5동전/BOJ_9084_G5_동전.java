import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ������ �������� �ϳ��� DP ������ ��! 
public class Main {
	
	//DP �迭 
	static int[] dp; 
	// ���� ���� �迭 
	static int[] coins;
	// ���ε� ���� ���� 
	static int num_coins;
	// ��Ÿ������ ���� 
	static int num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// �׽�Ʈ ���̽� �� 
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 0; test_case < T ; test_case++) {
			//���� ���� �Է�  
			num_coins = Integer.parseInt(br.readLine()); 
			// ���� �� �Է� 
			String coins_str[] = br.readLine().split(" ");
			coins = new int[num_coins];
			for(int i=0; i< num_coins; i++) {
				coins[i] = Integer.parseInt(coins_str[i]);
			}
			
			// ��Ÿ�� ���� �Է� 
			num = Integer.parseInt(br.readLine());
			
			// dp �迭 �ʱ�ȭ 
			dp = new int[num+coins[num_coins-1] + 1];
			//**********************INPUT***********************
			
			// 0���� ��� ���� 0���̹Ƿ� �� �ϳ�! 
			dp[0] = 1;
			// ���� ������ŭ DP ������ 
			for(int i=0;i<num_coins;i++) {
				sol(coins[i]);
			}
			// ����� ��� 
			System.out.println(dp[num]);
			
		}
	}
	// DP ���� 
	private static void sol(int idx) {
		// ���� idx = ���� ���� 3���̶��
		// ����Ǽ� : 0�� = 1 �̸� 
		// ����Ǽ� : 3�� = 1�̴�.
		// ����Ǽ� : 6�� = 1�̴�. 
		
		// �ι�° DP ���� idx = ���� ���� 2�� �̶��
		// ����Ǽ� : 0�� = 1 �̸� 
		// ����Ǽ� : 2�� = 1�̴�.
		// ����Ǽ� : 4�� = 1�̴�. 
		// ����Ǽ� : 6�� = 2�̴�. => dp[6] = dp[6] + dp[4] �̱� ������!!!!!! 
		for(int i = idx; i <= num ; i++ ) {
			dp[i] += dp[i - idx];
		}
	}
	
}
