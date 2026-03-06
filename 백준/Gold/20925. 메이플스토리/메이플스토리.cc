#include <vector>
#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int N, T;
vector<vector<int>>dp;
vector<int> c, e;
vector<vector<int>> dist;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> T;
	c.resize(N + 1);
	e.resize(N + 1);
	dist.resize(N + 1, vector<int>(N + 1));

	for (int i = 1; i <= N; i++) cin >> c[i] >> e[i];
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) cin >> dist[i][j];
	}
	dp.assign(N + 1, vector<int>(T + 1, -1));

	for (int i = 1; i <= N; i++) if (c[i] == 0) dp[i][0] = 0;

	for (int t = 0; t < T; t++) {
		for (int i = 1; i <= N; i++) {
			if (dp[i][t] == -1) continue;
			if (dp[i][t] >= c[i]) {
				dp[i][t + 1] = max(dp[i][t + 1], dp[i][t] + e[i]);
			}
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				int nt = t + dist[i][j];
				if (nt > T) continue;
				if (dp[i][t] >= c[j]) dp[j][nt] = max(dp[j][nt], dp[i][t]);
			}
		}
	}
	int rst = 0;
	for (int i = 1; i <= N; i++) rst = max(rst, dp[i][T]);
	cout << rst << '\n';
}