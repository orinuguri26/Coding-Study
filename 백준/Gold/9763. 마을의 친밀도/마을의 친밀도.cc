#include <vector>
#include <iostream>
#include <cmath>
#include <climits>
#include <algorithm>
using namespace std;

int N;
struct state { int x, y, z; };
vector<state> num;
int Min = INT_MAX;
int Fam(state s1, state s2) {
	int f1 = s1.x, S1 = s1.y, t1 = s1.z;
	int f2 = s2.x, S2 = s2.y, t2 = s2.z;
	return abs(f1 - f2) + abs(S1 - S2) + abs(t1 - t2);
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	num.resize(N + 1);
	for (int i = 0; i < N; i++) {
		int x, y, z;
		cin >> x >> y >> z;
		num[i] = { x, y, z };
	}
	int rst = INT_MAX;
	for (int i = 0; i < N; i++) {
		int Min1 = INT_MAX, Min2 = INT_MAX;
		for (int j = 0; j < N; j++) {
			if (i == j) continue;
			int d = Fam(num[i], num[j]);
			if (Min1 > d) {
				Min2 = Min1;
				Min1 = d;
			}
			else if (Min2 > d) Min2 = d;
		}
		rst = min(rst, Min1 + Min2);
	}
	cout << rst << '\n';
}