#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int num_poketmon = 0 , num_prob = 0;
	cin >> num_poketmon >> num_prob;
	vector<string> poketdogam_vec;
	vector<string> probs;
	vector<string> answer;
	unordered_map<string , int > poketdogam;
	
	
	for(int i=1; i<= num_poketmon ; i++){
		string poketmon_name;
		cin >> poketmon_name;
		poketdogam_vec.push_back(poketmon_name);
		poketdogam.insert(make_pair(poketmon_name , i));
	}
	
	for(int i=0; i< num_prob ; i++){
		string prob = "";
		cin >> prob;
		if(isdigit(prob[0]) != 0){
			answer.push_back( poketdogam_vec[stoi(prob , nullptr , 10)-1]);
		}
		else {
			answer.push_back( to_string(poketdogam.find(prob)->second ));
		}
		
	}
	
	for(int i=0; i< num_prob ; i++){
		cout << answer[i] << '\n';
	}
	
	return 0;
}