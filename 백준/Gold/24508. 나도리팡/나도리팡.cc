#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

long long N, K, T;
long long sum = 0;
long long cnt = 0;
vector<long long> A;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> K >> T;
	for (int i = 0; i < N; i++) {
		int a;
		cin >> a;
		A.push_back(a);
		sum += a;
	}
	if (sum % K != 0) {
		cout << "NO" << '\n';
		return 0;
	}
	sort(A.begin(), A.end());
	for (int i = 0; i < sum / K; i++) {
		cnt += K - A[A.size() - 1 - i];
	}
	cout << (cnt <= T ? "YES" : "NO") << '\n';
}