#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int x, y;
int T;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> T;
	while (T--) {
		cin >> x >> y;
		int dist = y - x;

		int i = sqrt(dist);

		if (dist == i * i) cout << 2 * i - 1 << '\n';
		else if (dist <= i * i + i) cout << 2 * i << '\n';
		else cout << 2 * i + 1 << '\n';
	}
}