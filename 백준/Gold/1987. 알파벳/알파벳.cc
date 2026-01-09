#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int R, C;
vector<vector<char>> alpha;
vector<bool> used;
int dir[4] = { -1, 1, 0, 0 };
int dic[4] = { 0, 0, -1, 1 };
int rst = 0;
void Board(int sr, int sc, int cnt)
{
	used[alpha[sr][sc] - 'A'] = true;
	cnt += 1;

	for (int i = 0; i < 4; i++)
	{
		int nr = sr + dir[i];
		int nc = sc + dic[i];
		if (nr < 1 || nr > R) continue;
		if (nc < 1 || nc > C) continue;
		int idx = alpha[nr][nc] - 'A';

		if (!used[idx])
		{
			Board(nr, nc, cnt);
		}
	}
	rst = max(rst, cnt);
	used[alpha[sr][sc] - 'A'] = false;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> R >> C;
	alpha.resize(R + 1, vector<char>(C+1));
	used.assign(26, false);
	for (int i = 1; i <= R; i++)
	{
		string str;
		cin >> str;
		for (int j = 1; j <= C; j++)
		{
			alpha[i][j] = str[j - 1];
		}
	}
	Board(1, 1, 0);
	cout << rst << '\n';                                            
}