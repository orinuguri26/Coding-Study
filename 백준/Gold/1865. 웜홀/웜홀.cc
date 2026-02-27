#include <vector>
#include <iostream>
#include <cmath>
#include <climits>
#include <algorithm>
using namespace std;

int TC, N, M, W;
int S, E, T;
int INF = 1e9;
int dist[501][501];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> TC;
	while (TC--) {
		cin >> N >> M >> W;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		for (int i = 0; i < M; i++) {
			cin >> S >> E >> T;
			dist[S][E] = min(dist[S][E], T);
			dist[E][S] = min(dist[E][S], T);
		}
		for (int i = 0; i < W; i++) {
			cin >> S >> E >> T;
			dist[S][E] = -T;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		bool valid = false;
		for (int i = 1; i <= N; i++) {
			if (dist[i][i] < 0) valid = true;
		}
		cout << (valid ? "YES" : "NO") << '\n';
	}
}