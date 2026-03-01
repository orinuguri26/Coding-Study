#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int N, M;
vector<string> maze;
vector<pair<int, int>> SaE;
vector<vector<bool>> visited;
vector<vector<pair<int, int>>> rst;
int dir[4] = { -1, 1, 0, 0 };
int dic[4] = { 0, 0, -1, 1 };
void BFS(vector<pair<int, int>> v) {
	queue<pair<int, int>> q;
	q.push({ v[0].first, v[0].second });
	visited[v[0].first][v[0].second] = true;

	while (!q.empty()) {
		int fr = q.front().first;
		int fc = q.front().second;
		q.pop();

		if (fr == v[1].first && fc == v[1].second) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = fr + dir[i];
			int nc = fc + dic[i];

			if (nr < 0 || nr >= N) continue;
			if (nc < 0 || nc >= M) continue;
			if (!visited[nr][nc] && maze[nr][nc] == '.') {
				visited[nr][nc] = true;
				q.push({ nr, nc });
				rst[nr][nc] = { fr, fc };
			}
		}
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M;
	maze.resize(N);
	visited.assign(N, vector<bool>(M, false));
	rst.resize(N, vector<pair<int, int>>(M));
	for (int i = 0; i < N; i++) cin >> maze[i];
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
				if (maze[i][j] == '.') SaE.push_back({ i,j });
			}
		}
	}
	BFS(SaE);
	vector<vector<bool>> check(N, vector<bool>(M, false));
	int r = SaE[1].first, c = SaE[1].second;
	while (!(r == SaE[0].first && c == SaE[0].second)) {
		check[r][c] = true;
		pair<int,int> p = rst[r][c];
		r = p.first;
		c = p.second;
	}
	check[SaE[0].first][SaE[0].second] = true;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (maze[i][j] == '+' || check[i][j]) continue;
			maze[i][j] = '@';
		}
	}
	for (int i = 0; i < N; i++) {
		cout << maze[i] << '\n';
	}
}