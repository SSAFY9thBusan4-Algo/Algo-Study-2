#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


struct mystack {
	int TOP;
	int stack_size;
	
	int* nums;
	void push(int x){
		this->nums[TOP++] = x;
	}
	void pop() {
		if(TOP != 0){
			cout << this->nums[--TOP] << "\n";
		}
		else {
			cout << -1 << "\n";
		}
	}
	void size() {
		cout << TOP << "\n";
	}
	void empty() {
		if(TOP != 0){
			cout << 0 << "\n";
		}
		else {
			cout << 1 << "\n";
		}
	}
	void top() {
		if(TOP != 0){
			cout << this->nums[TOP-1] << '\n';
		}
		else {
			cout << -1 << "\n";
		}
	}
	
	mystack(int size){
		this->nums = new int[size];
		this->TOP = 0;
	}
};



int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	
	int T = 0;
	cin >> T;
	
	mystack* ms = new mystack(10000);
	
	for(int test_case = 1; test_case <= T; test_case++){
		string comm;
		cin >> comm;
		if(comm == "push"){
			int x = 0;
			cin >> x;
			ms->push(x);		
		}
		else if(comm == "pop"){
			ms->pop();
		}
		else if(comm == "size"){
			ms->size();
		}
		else if(comm == "empty"){
			ms->empty();
		}
		else if(comm == "top"){
			ms->top();
		}
	}
	
	
	return 0;
}
