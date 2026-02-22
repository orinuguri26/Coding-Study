#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int R, C;
vector<string> bread;
vector<vector<bool>> visited;
int dir[3] = { -1, 0, 1 };
int dic[3] = { 1, 1, 1 };
bool DFS(pair<int, int> start) {
	for (int i = 0; i < 3; i++) {
		int nr = start.first + dir[i];
		int nc = start.second + dic[i];

		if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
		if (bread[nr][nc] == 'x' || visited[nr][nc]) continue;

		visited[nr][nc] = true;
		if (nc == C - 1) return true;
		if (DFS({ nr, nc })) return true;
	}
	return false;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> R >> C;
	bread.resize(R);
	visited.assign(R, vector<bool>(C, false));
	for (int i = 0; i < R; i++) cin >> bread[i];

	int rst = 0;
	for (int i = 0; i < R; i++) {
		visited[i][0] = true;
		if (DFS({ i, 0 })) rst++;
	}
	cout << rst << '\n';
}