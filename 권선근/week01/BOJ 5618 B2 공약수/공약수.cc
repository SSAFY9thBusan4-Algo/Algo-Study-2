#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
	int size;
	vector<int> nums;
	cin >> size;
	for(int i=0;i<size;i++){
		int temp;
		cin >> temp;
		nums.push_back(temp);
	}
	
	sort(nums.begin() , nums.end());
	int last = nums[0] / 2;
	
	cout << 1 << endl;
	if(size == 2){
		for(int i=2; i<= last ; i++){
			if(nums[0] % i == 0 && nums[1] % i == 0) {
				cout << i << endl;
			}
		}
		if(nums[1] % nums[0] == 0){
			cout << nums[0] << endl;
		}
	}
	else {
		for(int i=2; i<= last ; i++){
			if(nums[0] % i == 0 && nums[1] % i == 0 && nums[2] % i == 0) {
				cout << i << endl;
			}
		}
		//cout << nums[0] << nums[1] << nums[2] << endl;
		if(nums[1] % nums[0] == 0 && nums[2] % nums[0] == 0){
			cout << nums[0] << endl;
		}
	}
	
	return 0;
}
