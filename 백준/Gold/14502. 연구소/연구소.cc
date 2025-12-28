#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int N, M;
vector<vector<int>> lab;
vector<vector<int>> lab_1;
vector<vector<bool>> visited;
int dir[4] = { -1, 1, 0, 0 };
int dic[4] = { 0, 0, -1, 1 };
void Virus(pair<int, int> p)
{
	queue<pair<int, int>> q;
	q.push({ p.first, p.second });
	visited[p.first][p.second] = true;

	while (!q.empty())
	{
		int fr = q.front().first;
		int fc = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++)
		{
			int nr = fr + dir[i];
			int nc = fc + dic[i];

			if (nr < 0 || nr >= N) continue;
			if (nc < 0 || nc >= M) continue;
			if (lab_1[nr][nc] == 1) continue;

			if (!visited[nr][nc])
			{
				lab_1[nr][nc] = 2;
				q.push({ nr, nc });
				visited[nr][nc] = true;
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
	lab.resize(N, vector<int>(M));
	vector<pair<int, int>> safe;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			int a;
			cin >> a;
			lab[i][j] = a;
			if (a == 0) safe.push_back({ i,j });
		}
	}
	

	int Max = 0;
	for (int i = 0; i < safe.size() - 2; i++)
	{
		for (int j = i + 1; j < safe.size() - 1; j++)
		{
			for (int t = j + 1; t < safe.size(); t++)
			{
				lab_1 = lab;
				lab_1[safe[i].first][safe[i].second] = 1;
				lab_1[safe[j].first][safe[j].second] = 1;
				lab_1[safe[t].first][safe[t].second] = 1;

				visited.assign(N, vector<bool>(M, false));
				for (int k = 0; k < N; k++)
				{
					for (int e = 0; e < M; e++)
					{
						if (lab_1[k][e] != 2) continue;
						if (visited[k][e]) continue;
						Virus({ k, e });
					}
				}
				int cnt = 0;
				for (int v = 0; v < N; v++)
				{
					for (int x = 0; x < M; x++)
					{
						if (lab_1[v][x] != 0) continue;
						cnt += 1;
					}
				}
				Max = max(Max, cnt);
			}
		}
	}
	cout << Max << '\n';
}