#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

int N, M;
int A, B;
int rst[1001];
vector<vector<pair<int, int>>> bus;
int Root(int start, int end)
{
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, start });
	rst[start] = 0;
    
	while (!pq.empty())
	{
		int fweight = pq.top().first;
		int fnode = pq.top().second;
		pq.pop();
        
		if (rst[fnode] < fweight) continue;
        
		for (auto a : bus[fnode])
		{
			int nweight = a.first + fweight;
			if (rst[a.second] > nweight)
			{
				pq.push({ nweight, a.second });
				rst[a.second] = nweight;
			}
		}
	}
	return rst[end];
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	cin >> M;
	for (int i = 1; i <= N; i++) rst[i] = INT_MAX;
	bus.resize(N+1, vector<pair<int, int>>());
	for (int i = 0; i < M; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		bus[a].push_back({ c, b });
	}
	cin >> A >> B;
	cout << Root(A, B) << '\n';
}