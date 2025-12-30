#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int N, M;
vector<vector<int>> Map;
vector<vector<vector<bool>>> visited;
int dir[4] = { -1, 1, 0, 0 };
int dic[4] = { 0, 0, -1, 1 };
struct st
{
	int row;
	int col;
	int dis;
	bool broken;
};
void BFS(int r, int c, int d, bool b)
{
	queue<st> q;
	q.push({ r, c, d, b });
	visited[r][c][b] = true;

	while (!q.empty())
	{
		int fr = q.front().row;
		int fc = q.front().col;
		int fdis = q.front().dis;
		bool fb = q.front().broken;
		q.pop();

		if (fr == N && fc == M)
		{
			cout << fdis << '\n';
			return;
		}

		for (int i = 0; i < 4; i++)
		{
			int nr = fr + dir[i];
			int nc = fc + dic[i];

			if (nr < 1 || nr > N) continue;
			if (nc < 1 || nc > M) continue;

			if (Map[nr][nc] == 1)
			{
				if (!fb && !visited[nr][nc][1])
				{
					q.push({ nr, nc, fdis + 1, 1 });
					visited[nr][nc][1] = true;
				}
			}
			if (Map[nr][nc] == 0)
			{
				if (!visited[nr][nc][fb])
				{
					visited[nr][nc][fb] = true;
					q.push({ nr, nc, fdis + 1, fb });
				}
			}
		}
	}
	cout << -1 << '\n';
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M;
	Map.resize(N + 1, vector<int>(M + 1));
	visited.assign(N + 1, vector<vector<bool>>(M + 1, vector<bool>(2, false)));

	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= M; j++)
		{
			char c;
			cin >> c;
			Map[i][j] = c - '0';
		}
	}
	BFS(1, 1, 1, 0);
}