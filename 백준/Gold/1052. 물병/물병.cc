#include <string>
#include <vector>
#include <iostream>
#include <cmath>
#include <climits>
#include <algorithm>
#include <queue>
#include <map>
using namespace std;

int N, K;
int Bin(int n) {
	string str;
	int cnt = 0;
	while (n != 0) {
		str += (n % 2) + '0';
		n /= 2;
	}
	reverse(str.begin(), str.end());
	for (char c : str) if (c == '1') cnt++;
	return cnt;
	//cout << cnt << '\n';
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> K;
	int rst = 0;
	while (1) {
		int cnt_1 = Bin(N);
		if (cnt_1 <= K) {
			cout << rst << '\n';
			return 0;
		}
		N++;
		rst++;
	}
}