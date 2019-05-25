#include<bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	int t, m ,n;
	cin>>t>>m>>n;
	int arr[m][n];
	int arr1[t+1];
	memset(arr1, 0, sizeof(arr1)); 
	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			cin>>arr[i][j];
		}
	}
	for(int i=0;i<m;i++){
		int l=arr[i][0];
		int h=arr[i][1];
		arr1[l]+=arr[i][2];
		arr1[h+1]-=arr[i][2];
	}
    long long sum = 0, ans = INT_MIN; 
	for (int i=0; i < t; ++i) { 
        sum += arr1[i]; 
        ans = max(ans, sum); 
    } 
	cout<<ans<<endl;
	}