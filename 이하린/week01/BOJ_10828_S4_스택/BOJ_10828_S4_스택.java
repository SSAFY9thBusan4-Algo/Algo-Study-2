package dataStructure.arrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_10828_S4_���� {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); //����� �� N �Է� ����
		List<Integer> arr = new ArrayList<Integer>();
		
		for(int i = 0;i<N;i++) { //N�� �ݺ�
			
			String cmd = in.readLine(); //��� �Է� �ޱ�
			if (cmd.equals("pop")) { //����� pop�̸�
				if(arr.size() == 0) //������ ���������
					System.out.println(-1); //-1�� ���
				else { //������ ������� ������
					System.out.println(arr.get(arr.size()-1)); //���ÿ��� ���� ���� �ִ� ������ ���� �� ���� ���
					arr.remove(arr.size()-1); //���� �ֱٿ� ���� ���� arrayList���� ����
				}
			}
			else if(cmd.equals("size")) { //����� size��
				System.out.println(arr.size()); //arrayList�� ����ִ� ���� ���� ���
			}
			else if(cmd.equals("empty")) {//����� empty��
				if(arr.size() == 0) //���� ������ ��������� 
					System.out.println(1); //1 ���
				else //�ƴ϶��
					System.out.println(0); //0 ���
			}
			else if (cmd.equals("top")) { //����� top�̶��
				if (arr.size() == 0) // ���� ������ ���������
					System.out.println(-1); //-1 ���
				else //�ƴ϶��
					System.out.println(arr.get(arr.size()-1)); //���� �ֱٿ� ���� ���� arrayList���� ���
			}
			else if(cmd.substring(0, 4).equals("push")) { //����� push���
				int num = Integer.parseInt(cmd.substring(5, cmd.length()));
				arr.add(num); //arrayList�� �� �߰�
			}
			
			
		}
		
	}

}
