#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, Q;
vector<int> Astick;
vector<int> Lstick;
vector<int> dp;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	Astick.resize(N);
	for (int i = 0; i < N; i++) cin >> Astick[i];

	cin >> Q;
	Lstick.resize(Q);
	
	int LongS = 0;
	for (int i = 0; i < Q; i++)
	{
		cin >> Lstick[i];
		LongS = max(LongS, Lstick[i]);
	}

	dp.resize(LongS + 1, 0);
	for (auto a : Astick)
	{
		if (a > LongS) continue;
		dp[a] = 1;
	}

	for (int i = 1; i <= LongS; i++)
	{
		if (dp[i] == 0) continue;
		for (int j = 2; j * i <= LongS; j++)
		{
			dp[i * j] += dp[i];
		}
	}

	for (int i = 0; i < Q; i++) cout << dp[Lstick[i]] << " ";
}