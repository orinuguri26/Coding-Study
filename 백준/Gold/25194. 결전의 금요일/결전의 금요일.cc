#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int N;
vector<int> task;
vector<bool> dp;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	task.resize(N);
	for (int i = 0; i < N; i++) cin >> task[i];

	dp.assign(7, false);
	dp[0] = true;

	for (int i = 0; i < N; i++)
	{
		vector<int> day;
		for (int j = 0; j < 7; j++)
		{
			if (!dp[j]) continue;
			day.push_back((j + task[i]) % 7);
		}
		for (auto a : day)
		{
			dp[a] = true;
			if (a == 4)
			{
				cout << "YES" << '\n';
				return 0;
			}
		}
	}
	cout << "NO" << '\n';
}