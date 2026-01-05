#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, M;
vector<vector<int>> paper;
vector<vector<bool>> visited;
int Max = 0;
int dir[4] = { -1, 1, 0, 0 };
int dic[4] = { 0, 0, -1, 1 };
void DFS(int r, int c, int num, int sum)
{
	if (num == 4)
	{
		sum += paper[r][c];
		Max = max(Max, sum);
		return;
	}

	for (int i = 0; i < 4; i++)
	{
		int nr = r + dir[i];
		int nc = c + dic[i];

		if (nr < 0 || nr >= N) continue;
		if (nc < 0 || nc >= M) continue;

		if (!visited[nr][nc])
		{
			visited[nr][nc] = true;
			DFS(nr, nc, num + 1, sum + paper[r][c]);
			visited[nr][nc] = false;
		}
	}
}
void ShapeT(int r, int c)
{
	int upnr = r - 1;
	int upnc = c;

	int lnr = r;
	int lnc = c - 1;

	int rnr = r;
	int rnc = c + 1;
	
	int dnr = r + 1;
	int dnc = c;

	if (upnr >= 0 && lnc >= 0 && rnc < M)//ㅗ
	{
		int upT = paper[r][c] + paper[upnr][upnc] + paper[lnr][lnc] + paper[rnr][rnc];
		Max = max(upT, Max);
	}

	if (upnr >= 0 && lnc >= 0 && dnr < N)//ㅓ
	{
		int leftT = paper[r][c] + paper[upnr][upnc] + paper[lnr][lnc] + paper[dnr][dnc];
		Max = max(leftT, Max);
	}

	if (upnr >= 0 && rnc < M && dnr < N)//ㅏ
	{
		int rightT = paper[r][c] + paper[upnr][upnc] + paper[dnr][dnc] + paper[rnr][rnc];
		Max = max(rightT, Max);
	}

	if (dnr < N && lnc >= 0 && rnc < M)//ㅜ
	{
		int downT = paper[r][c] + paper[dnr][dnc] + paper[lnr][lnc] + paper[rnr][rnc];
		Max = max(downT, Max);
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M;
	paper.resize(N, vector<int>(M));
	visited.assign(N, vector<bool>(M, false));
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> paper[i][j];
		}
	}

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			visited[i][j] = true;
			DFS(i, j, 1, 0);
			visited[i][j] = false;
			ShapeT(i, j);
		}
	}
	cout << Max << '\n';
}