#include <string>
#include <vector>
#include <iostream>
#include <cmath>
#include <climits>
#include <algorithm>
#include <queue>
using namespace std;

int N, K;
vector<int> height;
vector<int> h_diff;
int rst = 0;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> K;
	height.resize(N);
	h_diff.resize(N - 1);
	for (int i = 0; i < N; i++) { 
		cin >> height[i];
		if (i == 0) continue;
		h_diff[i-1] = height[i] - height[i - 1];
		rst += h_diff[i - 1];
	}

	sort(h_diff.rbegin(), h_diff.rend());
	for (int i = 0; i < K-1; i++) {
		rst -= h_diff[i];
	}
	cout << rst << '\n';
}