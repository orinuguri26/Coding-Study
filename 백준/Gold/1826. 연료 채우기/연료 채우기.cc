#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int N, L, P;
vector<pair<int, int>> gas;
vector<bool> visited;
int cnt = 0;
void Drive(int end, int soil)
{
	priority_queue<int, vector<int>, less<int>> pq;

	while (soil < end)
	{
		for (int i = 0; i < N; i++)
		{
			if (gas[i].first > soil) continue;
			if (visited[i]) continue;

			pq.push(gas[i].second);
			visited[i] = true;
		}

		if (pq.empty())
		{
			cout << -1 << '\n';
			exit(0);
		}

		soil += pq.top();
		pq.pop();
		cnt++;
	}
	cout << cnt << '\n';
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	for (int i = 0; i < N; i++)
	{
		int a, b;
		cin >> a >> b;
		gas.push_back({ a, b });
	}
	sort(gas.begin(), gas.end());
	visited.assign(N, false);
	cin >> L >> P;

	Drive(L, P);
}