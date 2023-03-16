#include <iostream>
#include <vector>
using namespace std;


int max_visit = 0; // ���� ���� ���� �湮�� �� 
int count = 0; // max�� �p�� �����°�? 

// �߾� ��ǥ 
int row_center;
int col_center;
vector<vector<int>> board;


void sol(int cnt , int row , int col);
int N , M;
int main() {
	cin >> N >> M;
	
	// �迭���� 
	board.assign(N,vector<int>(N,0));
	
	// �߾Ӱ��� 1 
	row_center = N/2;
	col_center = N/2;
	board[row_center][col_center] = 1;
	
	// SOLUTION ����Լ� ����! 
	sol(1 , row_center , col_center);
	
	// �迭 ��ü ����ϱ�
	// M�� ã���� result_cord�� �����ߴٰ� ���߿� ������ش�. 
	pair<int,int> result_cord;
	for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
			cout << board[i][j] << " ";
			if(board[i][j] == M){
				result_cord = make_pair(i,j);
			}
		}
		cout << '\n';
	}
	cout << result_cord.first+1 << " " << result_cord.second+1 << '\n';
	return 0;
}

void sol( int cnt , int row , int col){
	
	if(col == 0){
		return;
	}
	
	// ��ĭ����  
	row--;
	board[row][col] = board[row+1][col] + 1;
	
	// ������ 
	for(int i=0;i<2*cnt-1;i++) {
		col++;
		board[row][col] = board[row][-1 + col] + 1;
	}
	// �Ʒ� 
	for(int i=1;i<= 2*cnt;i++) {
		row++;
		board[row][col] = board[row-1][col] + 1;
	} 
	// ���� 
	for(int i=1;i<= 2*cnt;i++) {
		col--;
		board[row][col] = board[row][col+1] + 1;
	} 
	// �� 
	for(int i=1;i<= 2*cnt;i++) {
		row--;
		board[row][col] = board[row+1][col] + 1;
	} 
	
	// ����ϱ� 
	sol(cnt+1, row , col);
}
