#include <string>
#include <vector>
#include <iostream>
#include <cmath>
#include <climits>
#include <algorithm>
#include <queue>
using namespace std;

int M;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> M;
	vector<long long> N = { 5, 13 };
	string messi1 = "Messi";
	string messi2 = "Messi Gimossi";

	while (M > N[N.size() - 1]) N.push_back(N[N.size() - 1] + 1 + N[N.size() - 2]);

	int idx = N.size() - 1;
	while (idx > 1)
	{
		if (M > N[idx - 1] + 1) {
			M -= (N[idx - 1] + 1);
			idx -= 2;
		}
		else if (M == N[idx - 1] + 1) {
			cout << "Messi Messi Gimossi" << '\n';
			exit(0);
		}
		else {
			idx -= 1;
		}
	}
	if (idx == 1) {
		if(M == 6) cout << "Messi Messi Gimossi" << '\n';
		else cout << messi2[M - 1] << '\n';

	}
	else {
		cout << messi1[M - 1] <<'\n';
	}
}