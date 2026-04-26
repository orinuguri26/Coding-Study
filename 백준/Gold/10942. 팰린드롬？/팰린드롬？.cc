#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
vector<int> num;
vector<vector<bool>> dp;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	
	cin >> N;
	num.resize(N + 1);
	dp.assign(N + 1, vector<bool>(N + 1, false));
	for (int i = 1; i <= N; i++) cin >> num[i];

	cin >> M;
	for (int i = 1; i <= N; i++) dp[i][i] = true;
	for (int i = 2; i <= N; i++) if (num[i-1] == num[i]) dp[i-1][i] = true;

	for (int i = 3; i <= N; i++) {
		for (int s = 1; s + i - 1 <= N; s++) {
			if (num[s] != num[s + i - 1]) continue;
			if (dp[s + 1][s + i - 1 - 1]) dp[s][s + i - 1] = true;
		}
	}
	while (M--) {
		int S, E;
		cin >> S >> E;
		cout << dp[S][E] << '\n';
	}
}