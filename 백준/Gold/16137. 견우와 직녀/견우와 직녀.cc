#include <string>
#include <vector>
#include <iostream>
#include <cmath>
#include <climits>
#include <algorithm>
#include <queue>
using namespace std;

int N, M;
int rst = INT_MAX;
int dir[4] = { -1, 1, 0, 0 };
int dic[4] = { 0, 0, -1, 1 };
vector<vector<int>> area;
vector<vector<bool>> visited;
vector<pair<int, int>> wall;
struct state {
	int row, col, time;
};
void BFS(int sr, int sc, int st)
{
	queue<state> q;
	q.push({ sr, sc, st });
	visited[sr][sc] = true;
	while (!q.empty())
	{
		int fr = q.front().row;
		int fc = q.front().col;
		int ft = q.front().time;
		q.pop();

		if (fr == N - 1 && fc == N - 1)
		{
			rst = min(rst, ft);
			return;
		}

		for (int i = 0; i < 4; i++)
		{
			int nr = fr + dir[i];
			int nc = fc + dic[i];
			int nt = ft + 1;

			if (nr < 0 || nr >= N) continue;
			if (nc < 0 || nc >= N) continue;
			if (visited[nr][nc]) continue;
			if (area[nr][nc] == 1) //갈 수 있는 땅이면
			{
				if (!visited[nr][nc])
				{
					q.push({ nr, nc, nt});
					visited[nr][nc] = true;
				}
			}
			else if (area[nr][nc] >= 2) //갈 곳이 오작교면
			{
				if (area[fr][fc] >= 2) continue; //오작교 연속 불가
				if (nt % area[nr][nc] != 0) q.push({fr, fc, nt});
				else
				{
					q.push({nr, nc, nt});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M;
	area.resize(N, vector<int>(N));
	for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) cin >> area[i][j];

	for (int i = 0; i < N; i++) { //교차 절벽 처리
		for (int j = 0; j < N; j++) {
			if (area[i][j] != 0) continue;
			if (((i - 1 >= 0 && area[i - 1][j] == 0) || (i + 1 < N && area[i + 1][j] == 0)) &&
				((j - 1 >= 0 && area[i][j - 1] == 0) || (j + 1 < N && area[i][j + 1] == 0))) {
				continue;
			}
			wall.push_back({ i,j });
		}
	}
	for (auto w : wall)
	{
		visited.assign(N, vector<bool>(N, false));
		area[w.first][w.second] = M;
		BFS(0, 0, 0);
		area[w.first][w.second] = 0;
	}
	cout << rst << '\n';
}