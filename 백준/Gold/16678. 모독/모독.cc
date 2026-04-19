#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int N;
vector<int> honor;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	honor.resize(N + 1);
	for (int i = 1; i <= N; i++) cin >> honor[i];
	sort(honor.begin()+1, honor.begin()+N+1);

	long long rst = 0;
	int cut = 1;
	for (int i = 1; i <= N; i++) {
		if (honor[i] < cut) continue;
		rst += honor[i] - cut;
		cut++;
	}
	cout << rst << '\n';
}