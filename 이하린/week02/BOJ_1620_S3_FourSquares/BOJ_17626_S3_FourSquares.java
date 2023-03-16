package ssafy.com.study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_17626_S3_FourSquares {
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine()); //n�Է�
		int dp[] = new int[n+1]; //dp �迭 ����
		List<Integer> squares = new ArrayList<Integer>(); //�������� �����ϴ� arrayList

		/**
		 * ��ȭ�� min(dp[i - ������] + 1)��
		 * �׳� ���� 1���� ����� ��Ģ�� ã������ �ϴٰ� ã�ԵǾ����ϴ�!
		 */
		
		for(int i = 1; i<= n;i++) {//n���� �ݺ�
			if(Math.sqrt(i) == Math.floor(Math.sqrt(i))) { //���� i�� ���������
				squares.add(i); //square ����Ʈ�� �߰����ֱ�
				dp[i] = 1; //��������� dp[i] = 1�̴�.
			}
			else { //�������� �ƴ϶��
				int min = Integer.MAX_VALUE; //���� ���� ���ϱ� ���� min ����
				for(int num: squares) {
					if(min > dp[i - num] + 1) //���� min�� dp[i-num]+1 ���� ũ�ٸ� min ������ �ش� �� �Ҵ�
						min = dp[i-num]+1;
				}
				dp[i] = min; //dp[i]�� min �� �Ҵ�
			}
		}
		
		System.out.println(dp[n]);
		
	}
	
}
