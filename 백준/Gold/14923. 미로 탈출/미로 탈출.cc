#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int N, M;
pair<int, int> start, finish;
vector<vector<int>> maze;
vector<vector<vector<bool>>> visited;
int dir[4] = { -1, 1, 0, 0 };
int dic[4] = { 0, 0, - 1, 1 };
struct state {
	int r, c, dist;
	bool broke;
};
void BFS(pair<int, int> s, pair<int, int> e) {
	queue<state> q;
	q.push({ s.first, s.second, 0, false});
	visited[s.first][s.second][0] = true;

	while (!q.empty()) {
		int fr = q.front().r;
		int fc = q.front().c;
		int fdist = q.front().dist;
		bool fbroke = q.front().broke;
		q.pop();

		if (fr == e.first && fc == e.second) {
			cout << fdist << '\n';
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = fr + dir[i];
			int nc = fc + dic[i];
			
			if (nr > N || nr < 1 || nc > M || nc < 1) continue;
			if (maze[nr][nc] == 1) {
				if (!fbroke) {
					q.push({ nr, nc, fdist + 1, true });
					visited[nr][nc][1] = true;
				}
			}
			else {
				if (!visited[nr][nc][fbroke]) {
					q.push({ nr, nc, fdist + 1, fbroke });
					visited[nr][nc][fbroke] = true;
				}
			}
		}
	}
	cout << -1 << '\n';
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M;
	maze.resize(N + 1, vector<int>(M + 1));
	visited.assign(N + 1, vector<vector<bool>>(M + 1, vector<bool>(2, false)));
	cin >> start.first >> start.second;
	cin >> finish.first >> finish.second;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) cin >> maze[i][j];
	}
	BFS(start, finish);
}