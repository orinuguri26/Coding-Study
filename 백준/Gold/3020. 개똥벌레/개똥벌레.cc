#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int N, H;
vector<int> suck;
vector<int> jong;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> H;
	suck.resize(H+1);
	jong.resize(H+1);

	for (int i = 1; i <= N; i++) {
		int h;
		cin >> h;
		if (i % 2 != 0) suck[h]++;
		else jong[h]++;
	}

	for (int i = H - 2; i > 0; i--) {
		suck[i] += suck[i + 1];
		jong[i] += jong[i + 1];
	}

	int Min = N;
	int rst = 1;
	for (int i = 1; i <= H; i++) {
		int sum = suck[i] + jong[H - i + 1];
		if (sum < Min) {
			Min = sum;
			rst = 1;
		}
		else if (sum == Min) rst++;
	}
	cout << Min << ' ' << rst << '\n';
}