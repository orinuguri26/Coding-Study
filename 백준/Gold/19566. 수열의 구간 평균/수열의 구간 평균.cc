#include <string>
#include <vector>
#include <iostream>
#include <cmath>
#include <climits>
#include <algorithm>
#include <queue>
#include <map>
#include <unordered_map>
using namespace std;

long long N, K;
vector<long long> A;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> K;
	A.resize(N);
	for (int i = 0; i < N; i++) {
		long long a;
		cin >> a;
		A[i] = a - K;
	}

	long long sum = 0, rst = 0;
	unordered_map<long long, long long> um;
	um[0]++;
	for (int i = 0; i < N; i++) {
		sum += A[i];
		if (um.count(sum)) {
			rst += um[sum];
		}
		um[sum]++;
	}
	cout << rst << '\n';
}