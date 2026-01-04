#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
using namespace std;

long long N, K;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> K;

	long long len = 1;
	long long num = 9;

	while (K > len * num)
	{
		K -= len * num;
		len += 1;
		num *= 10;
	}

	long long t = pow(10, (len-1)) + ((K - 1) / len);
	if (t > N)
	{
		cout << -1 << '\n';
		return 0;
	}
	string str = to_string(t);
	cout << str[(K - 1) % len] << '\n';
}