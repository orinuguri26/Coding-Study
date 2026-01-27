#include <string>
#include <vector>
#include <iostream>
#include <cmath>
#include <climits>
#include <algorithm>
#include <queue>
using namespace std;

int N;
int sum = 0;
vector<vector<pair<int,int>>> connect;
vector<bool> visited;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	connect.resize(N);
	for (int i = 0; i < N; i++)
	{
		string str;
		cin >> str;
		for (int j = 0; j < N; j++)
		{
			int tmp = 0;
			if (str[j] == '0') tmp = 0;
			else if (str[j] - 'a' < 0) tmp = str[j] - 'A' + 27;
			else tmp = str[j] - 'a' + 1;
			sum += tmp;

			if (i == j) continue;
			if (tmp == 0) continue;
			connect[i].push_back({ tmp, j });
			connect[j].push_back({ tmp, i });
		}
	}

	int rst = 0;
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	visited.assign(N, false);
	pq.push({ 0, 0 });

	while (!pq.empty())
	{
		int fc = pq.top().second;
		int w = pq.top().first;
		pq.pop();

		if (visited[fc]) continue;
		visited[fc] = true;
		rst += w;
		for (auto a : connect[fc]) pq.push({ a.first, a.second });
	}
	for (auto a : visited)
	{
		if (!a)
		{
			cout << -1 << '\n';
			return 0;
		}
	}
	cout <<  sum - rst << '\n';
}