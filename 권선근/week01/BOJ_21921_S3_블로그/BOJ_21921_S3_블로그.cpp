#include <iostream>

using namespace std;


int max_visit = 0; // ���� ���� ���� �湮�� �� 
int count = 0; // max�� �p�� �����°�? 
int main() {
	int X , N;
	
	// �Է¹ޱ� 
	cin >> N >> X;
	
	// �Է°� ���� �迭 ���� 
	int visits[N] = {0,};
	for(int i=0; i<N;i++){
		cin >> visits[i];
	}
	
	// �ʱ� ������ : ���ʺ��� X�� �� ���ؼ� max , count ���� 
	int temp_sum = 0;
	for(int i=0;i<X;i++){
		temp_sum += visits[i];
	}
	max_visit = temp_sum;
	count = 1;
	
	
	// ���ʺ��� �����̵� ������
	// �� == max �̸� count++
	// �� > max �̸� max = �� , count = 1;
	// �� < max �̸� continue
	
	for(int i=X;i<N;i++){
		temp_sum -= visits[i-X];
		temp_sum += visits[i];
		
		if(max_visit > temp_sum){
			continue;
		}
		else if(max_visit == temp_sum){
			count++;
		}
		else if(max_visit < temp_sum){
			max_visit = temp_sum;
			count = 1;
		}
	}
	
	
	// �ִ� �湮�� ���� 0�̸� SAD
	// �ƴϸ� �ִ�湮�ڼ� , Ƚ�� �� 
	if(max_visit == 0){
		cout << "SAD" << '\n';
	}
	else {
		cout << max_visit << '\n' << count << '\n';
	}
	return 0;
}
