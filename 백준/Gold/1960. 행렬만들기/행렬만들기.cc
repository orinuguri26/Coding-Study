#include <string>
#include <vector>
#include <iostream>
#include <cmath>
#include <climits>
#include <algorithm>
#include <queue>
#include <map>
#include <unordered_map>
#include <cstring>
using namespace std;

int n;
struct state {
	int size, index;
};
bool cmp(state a, state b) {
	if (a.size == b.size) return a.index < b.index;
	return a.size > b.size;
}
vector<state> R, C;
vector<vector<int>> rst;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n; 
	R.resize(n + 1);
	C.resize(n + 1);
	rst.resize(n + 1, vector<int>(n + 1, 0));
	int sumR = 0, sumC = 0;
	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;
		sumR += a;
		R[i] = { a, i };
	}

	for (int i = 1; i <= n; i++) {
		int b;
		cin >> b;
		sumC += b;
		C[i] = { b, i };
	}
	if (sumR != sumC) {
		cout << -1;
		return 0;
	}

	sort(R.begin() + 1, R.begin() + n + 1, cmp);

	for (int i = 1; i <= n; i++) {
		sort(C.begin() + 1, C.begin() + n + 1, cmp);
		for (int j = 1; j <= n; j++) {
			if (R[i].size <= 0) break;
			if (C[j].size <= 0) continue;
			R[i].size -= 1;
			C[j].size -= 1;
			rst[R[i].index][C[j].index] = 1;
		}
	}
	for (int i = 1; i <= n; i++) {
		if (R[i].size != 0 || C[i].size != 0) {
			cout << -1;
			return 0;
		}
	}
	cout << 1 << '\n';
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cout << rst[i][j] << " ";
		}
		cout << '\n';
	}
}