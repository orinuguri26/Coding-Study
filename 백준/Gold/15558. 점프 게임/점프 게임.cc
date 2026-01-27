#include <vector>
#include <string>
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int N, K;
vector<vector<int>> foot;
vector<vector<bool>> visited;
struct state
{
	int pos, line, time;
};
int JG(int sp, int sl, int st)
{
	queue<state> q;
	q.push({ sp, sl, st });
	visited[sp][sl] = true;

	while (!q.empty())
	{
		int fp = q.front().pos;
		int fl = q.front().line;
		int ft = q.front().time;
		q.pop();

		int fnp = fp + 1, jnp = fp + K;
		int jnl = (fl + 1) % 2; // 삼항, 1에서 빼기
		if (fnp > N || jnp > N) return 1;

		if (foot[fnp][fl] == 1 && !visited[fnp][fl] && fnp > ft)
		{
			q.push({ fnp, fl, ft + 1 });
			visited[fnp][fl] = true;
		}

		if (foot[fp - 1][fl] == 1 && !visited[fp - 1][fl] && fp-1 > ft)
		{
			q.push({ fp - 1, fl, ft + 1 });
			visited[fp - 1][fl] = true;
		}

		if (foot[jnp][jnl] == 1 && !visited[jnp][jnl] && jnp > ft)
		{
			q.push({ jnp, jnl, ft + 1 });
			visited[jnp][jnl] = true;
		}
	}
	return 0;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> K;
	foot.resize(N + 1, vector<int>(2));
	visited.assign(N + 1, vector<bool>(2, false));
	
	for (int i = 0; i < 2; i++)
	{
		string str;
		cin >> str;
		for (int j = 1; j <= N; j++) foot[j][i] = str[j-1] - '0';
	}
	cout << JG(1, 0, 1) << '\n';
}