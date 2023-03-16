#include<vector>
#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int main() {
	int n = 0 , sum = 0;
	
	cin >> n; // �Է°� �ޱ�
	
	vector<int> dp(n+1,0);
	// 1�� 1^2 �ϳ��� �����Ѵ�. 
	dp[1] = 1;
	
	// DP �� ����
	// �˴ٽ��� i = ���������� �� �̾�� �Ѵ�.
	// DP[20] �� ã�´ٰ� ��������.
	// �׷��ٸ� 20 = X(���� ���������� ��) + Y^2 �̾�߸� �Ѵ�.
	// ���� �츮�� X = 20 - Y^2 ���� �����ϰ�
	// Y=1 ���� Y^2  �� 20���� Ŀ���� ������ ���� �ʴ� ������ �����Ͽ� X�� ���Ѵ�..
	// ���� ������ DP[X] �� (���� ���� �� + 1) �� DP[20]�� �����Ѵ�. 
	for(int i = 2; i <= n ; i++) {
		dp[i] = 999999999;
		for(int j = 1; j*j <= i ; j++){
			int chai = i - j*j;
			dp[i] = min(dp[chai] + 1 , dp[i]);
		}
		//cout << i << " " << dp[i] << '\n';
	}
	cout << dp[n] << '\n';
	return 0;
}
