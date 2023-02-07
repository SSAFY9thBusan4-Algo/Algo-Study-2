#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <set> 
using namespace std;


unordered_map<int, int> umap;
unordered_map<int , int> rmap;

set<int> rset;
set<int> lset;
int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int u = 5 , v = 5;
	
	bool endflag = false;
	int case_num = 1;
	while(endflag != true){
		bool flag = false;
		rset.clear();
		lset.clear();
		
		while(true){
			cin >> u >> v;
			if(u == 0){
				break;
			}
			else if(u < 0) {
				endflag = true;
				return 0;
			}
			rset.insert(u);
			if(!lset.insert(v).second){
				//cout << "double input" << endl;
				flag = true;
			}
		}
		
		//들어오는 간선이 없는 노드 root를 찾는다.
		//root가 두개이거나 0개이면 root = 0 리턴 
		int root = 0;
		
		for(auto it = rset.begin(); it != rset.end() ; it++){
			bool rootflag = true;
			for(auto itt = lset.begin(); itt != lset.end(); itt++){
				if(*it == *itt){
					rootflag = false;
					break;
				}
			}
			if(rootflag){
				if(root == 0){
					root = *it;
				}
				else {
					root = 0;
					break;
				}

			}
		}
		if(root == 0){
			flag = true;
		}
		//cout << "Root" << root << endl;
		
		if(rset.size() == 0){
			flag = false;
		}
		if( flag) {
			cout << "Case " << case_num++ << " is not a tree." << endl;
		} else {
			cout << "Case " << case_num++ << " is a tree." << endl;
		}
	}
	
	
	
	
	return 0;
}