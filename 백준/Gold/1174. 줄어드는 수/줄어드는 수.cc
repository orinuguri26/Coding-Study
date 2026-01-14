#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N;
vector<long long> decnum;
void Decnum(long long num, int idx)
{
	for (int i = 0; i < idx; i++)
	{
		long long tmp = num * 10 + i;
		decnum.push_back(tmp);
		Decnum(tmp,  i);
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	Decnum(0, 10);
	sort(decnum.begin(), decnum.end());

	if (N > decnum.size())
	{
		cout << -1 << '\n';
		return 0;
	}
	cout << decnum[N - 1] << '\n';
}