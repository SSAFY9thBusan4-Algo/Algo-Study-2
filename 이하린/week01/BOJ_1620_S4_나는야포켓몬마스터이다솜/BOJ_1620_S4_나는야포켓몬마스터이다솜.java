package dataStructure.arrayList;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BOJ_1620_S4_���¾����ϸ󸶽����̴ټ� {
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("input.txt"));
		
		/**
		 * ������ ���ϵǾ� �ִ� ���ϸ��� ���� N�� ����� �ϴ� ���� ���� M �Է� �ޱ�
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = in.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		/**
		 * �������� �ٷ� ã�� �� �ֵ��� HashMap�� ArrayList ����
		 * String(Name)���� ã�� �� String Key�� �ٷ� ������ �� �ְԲ� HashMap���� �����߰�,
		 * Integer(Num)���� ã�� �� ArrayList�� �ε����� ������ �����ϹǷ� ArrayList�� ����
		 */
		HashMap<String, Integer> pocketName = new HashMap<String, Integer>();
		List<String> pocketNum = new ArrayList<String>();
		
		/**
		 * N�� ���鼭 ���ϸ� ������ ���� ���� ���
		 */
		for(int i=1;i<=N;i++) {
			String pocketmon = in.readLine();
			pocketName.put(pocketmon, i);
			pocketNum.add(pocketmon);
		}
		
		/**
		 * �� �� ã�� �� �ݺ������� ������ �� �� Ž���ϸ� �ð� �ʰ��� ���.
		 * �׷��� ������ �ٷ� ���ϴ� ���� ã�� �� �ֵ��� get �Լ� ���
		 * ���ϸ��� �̸��� ù���ڸ� �빮�ڶ�� ������ �־��� ������ �ش� ������ ����Ͽ� �Է��� Name�̶�� ���� �ľ��Ѵ�.
		 */
		for(int i=0;i<M;i++) {
			String question = in.readLine();
			char firstCh = question.charAt(0);
			
			if (('A' <= firstCh && firstCh <= 'Z') /*|| ('a' <= firstCh && firstCh <= 'z')*/) {
				System.out.println(pocketName.get(question));
			}
			else {
				System.out.println(pocketNum.get(Integer.parseInt(question)-1));
			}
			
		}
		
	}
	
 }
