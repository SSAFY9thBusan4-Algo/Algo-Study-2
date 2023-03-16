package dataStructure.arrayList;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_5618_B2_����� {
	
public static void main(String[] args) throws Exception {
		
		
		//System.setIn(new FileInputStream("input.txt"));		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		/**
		 * �ڿ��� n�� �Է¹���.
		 */
		int n = Integer.parseInt(in.readLine());
		
		/**
		 * n���� ������� �Է¹޴´�.
		 * int �迭 num�� n�� ũ��� ������� ũ�⸦ 3���� �����ؼ� ����
		 * min�� �Է¹��� �� �߿��� ���� ���� ���� ã������ ������ ����
		 */
		String[] input = in.readLine().split(" ");
		int[] num = new int[3];
		int min = Integer.MAX_VALUE;
		
		/**
		 * �Է¹��� �迭 input�� ũ�⸸ŭ for�� �ݺ�
		 * String -> int�� Ÿ�� ��ȯ ��
		 * ���� ���� ���� min�� ã��.
		 * ������� ã�� ����� �ϱ� ���ؼ� ���� n�� 2��� (�Է¹��� ���� 2�����), num[2]�� 0�� �������ش�. (���ǹ��� ���� ����)
		 */
		for(int i =0;i<input.length;i++) {
			num[i] = Integer.parseInt(input[i]);
			if (min > num[i])
				min = num[i];
		}
		if (n==2) num[2] = 0;
		
		/**
		 * for������ i�� 1���� min���� �ݺ��Ѵ�.
		 * num[0], num[1], num[2]�� ��� i�� �������� �� �������� 0�̶�� i�� n���� ���� ������̹Ƿ� �ٷ� i�� ����Ѵ�.
		 */
		for(int i=1;i<=min;i++) {
			if (num[0] % i == 0 && num[1] % i == 0 && num[2] % i == 0)
				System.out.println(i);
		}
		
	}
}
