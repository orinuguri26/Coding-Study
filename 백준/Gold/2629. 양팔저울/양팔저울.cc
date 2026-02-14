#include <vector>
#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int W, B;
vector<int> weight;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> W;
	weight.resize(W + 1);
	for (int i = 1; i <= W; i++) cin >> weight[i];

	vector<vector<bool>> dp(W+1, vector<bool>(15001, false));
	dp[0][0] = true;

	for (int i = 1; i <= W; i++) {
		for (int j = 0; j <= 15000; j++) {
			if (!dp[i-1][j]) continue;

			dp[i][j] = true;
			dp[i][abs(j - weight[i])] = true;
			if (j + weight[i] > 15000) continue;
			dp[i][j + weight[i]] = true;
		}
	}
	cin >> B;
	while (B--) {
		int Bw;
		cin >> Bw;

		if (Bw <= 15000 && dp[W][Bw]) cout << "Y ";
		else cout << "N ";
	}
}