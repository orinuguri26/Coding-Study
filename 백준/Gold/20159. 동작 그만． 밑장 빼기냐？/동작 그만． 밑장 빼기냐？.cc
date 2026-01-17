#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N;
vector<int> num;
vector<vector<int>> sum;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	num.resize(N+1);
	sum.assign(N/2 + 1, vector<int>(2, 0));

	for (int i = 1; i <= N; i++)
	{
		cin >> num[i];
		if (i % 2 != 0) //홀수 sum[x][1]
		{
			int idx = i / 2 + 1;
			sum[idx][1] = sum[idx-1][1] + num[i];
		}
		else //짝수 sum[x][0]
		{
			int idx = i / 2;
			sum[idx][0] = sum[idx - 1][0] + num[i];
		}
	}

	int Max = 0;
	for (int i = 1; i <= N / 2; i++)
	{
		Max = max(Max, sum[N / 2][0] - sum[i - 1][0] + sum[i - 1][1]);
		Max = max(Max, sum[i][1] + sum[N / 2 -1][0] - sum[i - 1][0]);
	}
	cout << Max << '\n';
}