#include <string>
#include <vector>
#include <iostream>
#include <cmath>
#include <climits>
#include <algorithm>
#include <queue>
using namespace std;

int N;
vector<int> num;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	num.resize(N);
	int mid = N / 2 + 1;

	if (N == 1) {
		cout << 1 << '\n';
		return 0;
	}
	for (int i = 0; i < N; i++) {
		if (i % 2 == 0) num[i] = mid += i; //홀수 번
		else num[i] = mid -= i;
	}
	for (auto a : num) {
		cout << a << " ";
	}
}