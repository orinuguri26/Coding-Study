#include <string>
#include <vector>
#include <iostream>
#include <cmath>
#include <climits>
#include <algorithm>
#include <queue>
using namespace std;

int N;
int rst = INT_MAX;
vector<int> people;
vector<vector<int>> area;
vector<int> areaA;
vector<int> areaB;
vector<bool> visited;
bool BFS(vector<int> A) {
	visited.assign(N + 1, false);
	queue<int> q;
	q.push(A[0]);
	visited[A[0]] = true;

	vector<bool> same(N + 1, false);
	for (auto a : A) same[a] = true;

	while (!q.empty()) {
		int fa = q.front();
		q.pop();

		for (auto a : area[fa]) {
			if (!visited[a] && same[a]) {
				q.push(a);
				visited[a] = true;
			}
		}
	}
	for (int i = 1; i <= N; i++) {
		if (same[i] && !visited[i])
			return false;
	}
	return true;
}
void per() {
	for (int i = 1; i <= N / 2; i++) {
		vector<int> num(N + 1, 0);

		for (int j = 0; j < i; j++) num[N - 1 - j] = 1;

		do {
			areaA.clear();
			areaB.clear();
			int pA = 0, pB = 0;
			for (int p = 0; p < N; p++) {
				if (num[p]) {
					areaA.push_back(p+1);
					pA += people[p+1];
				}
				else { 
					areaB.push_back(p+1);
					pB += people[p+1];
				}
			}
			if(BFS(areaA) && BFS(areaB)) rst = min(rst, abs(pA - pB));
		} while (next_permutation(num.begin(), num.end()));
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	people.resize(N+1);
	area.resize(N+1);
	for (int i = 1; i <= N; i++) cin >> people[i];

	for(int j = 1; j <= N; j++) {
		int n;
		cin >> n;
		for (int i = 0; i < n; i++) {
			int a;
			cin >> a;
			area[j].push_back(a);
		}
	}
	per();
	if (rst == INT_MAX) cout << -1 << '\n';
	else cout << rst << '\n';
}