#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
using namespace std;

int N, K;
double rst[51][51];
vector<vector<pair<int,int>>> city;
struct state
{
	double dis;
	int node, pcnt;
};
struct cmp
{
	bool operator()(state a, state b)
	{
		return a.dis > b.dis;
	}
};
double Trip(int start, int end)
{
	priority_queue<state, vector<state>, cmp> pq;
	pq.push({ 0,start,0 });
	rst[start][0] = 0;

	while (!pq.empty())
	{
		double fdis = pq.top().dis;
		int fnode = pq.top().node;
		int fpcnt = pq.top().pcnt;
		pq.pop();

		if (rst[fnode][fpcnt] < fdis) continue;

		for (auto a : city[fnode])
		{
			double ndis = a.first;
			if (fpcnt < K)
			{
				if (rst[a.second][fpcnt+1] > fdis + (ndis / 2))
				{
					pq.push({ fdis + (ndis / 2), a.second, fpcnt + 1 });
					rst[a.second][fpcnt+1] = fdis + (ndis / 2);
				}
			}
			if (rst[a.second][fpcnt] > fdis + ndis)
			{
				pq.push({ fdis + ndis, a.second, fpcnt });
				rst[a.second][fpcnt] = fdis + ndis;
			}
		}
	}
	double Min = rst[end][0];
	for (int i = 1; i <= K; i++)
	{
		Min = min(Min, rst[end][i]);
	}
	return Min;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> K;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j <= K; j++)
		{
			rst[i][j] = 1e9;
		}
	}
	city.resize(N);
	for (int i = 0; i < N; i++)
	{
		string str;
		cin >> str;
		for (int j = 0; j < N; j++)
		{
			if (i == j) continue;
			city[i].push_back({str[j] - '0', j});
		}
	}
	cout << Trip(0, 1) << '\n';
}