#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int d, n, m;
vector<int> stone;
int Find(int start, int end)
{
	int left = start;
	int right = end;
	int mid = (left + right) / 2;
	while (left <= right)
	{
		int cnt = 0;
		mid = (left + right) / 2;
		int prev = 0;
		for (int i = 0; i <= n; i++)
		{
			if (stone[i] - prev < mid)
			{
				cnt++;
				continue;
			}
			prev = stone[i];
		}
		if (cnt > m)
		{
			right = mid - 1;
			continue;
		}
		left = mid + 1;
	}
	return right;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> d >> n >> m;
	stone.resize(n+1);
	for (int i = 0; i < n; i++) cin >> stone[i];
	stone[n] = d;
	sort(stone.begin(), stone.end());

	cout << Find(0, d) << '\n';
}