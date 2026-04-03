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

vector<vector<bool>> paper(10, vector<bool>(10));
vector<int> colors(6, 0);
int Min = 26;
bool check() {
	int sum = 0;
	for (int i = 1; i <= 5; i++) {
		sum += colors[i];
		if (colors[i] > 5 || sum > Min) {
			return false;
		}
	}
	return true;
}
void DFS() {
	if (!check()) return;

	vector<pair<int, int>> start;
	bool letsgo = false;
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
			if (paper[i][j]) {
				start.push_back({ i,j });
				letsgo = true;
				break;
			}
		}
		if (letsgo) break;
	}

	if (letsgo) {
		for (int s = 5; s > 0; s--) {
			vector<pair<int, int>> pos;
			bool valid = true;
			int r = start[0].first;
			int c = start[0].second;

			if (r + s > 10 || c + s > 10) continue;
			for (int n = r; n < r + s; n++) {
				for (int m = c; m < c + s; m++) {
					if (!paper[n][m]) { //하나라도 0이면 못붙임
						valid = false;
						break;
					}
					pos.push_back({ n,m }); //0이아닌애들 즉 붙일 수 잇는애들 잡아놓음
				}
				if (!valid) break; //못붙이면 끝내고 다음 s로 가게
			}
			if (valid) { // s크기의 색종이가 붙을 수 있다면 해당 좌표들을 0으로 바꿈(붙였다)
				for (auto a : pos) paper[a.first][a.second] = false;
				colors[s]++;
				DFS();
				colors[s]--;
				for (auto a : pos) paper[a.first][a.second] = true;
			}
		}
	}

	if (!letsgo) {
		int sum = 0;
		for (int i = 1; i < colors.size(); i++) sum += colors[i];
		Min = min(Min, sum);
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
			int a;
			cin >> a;
			paper[i][j] = a;
		}
	}
	DFS();
	if (Min > 25) cout << -1 << '\n';
	else cout << Min << '\n';
}