#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int N, M, T;
int xi, di, ki;
int dir[4] = {1, -1, 0, 0};
int dic[4] = {0, 0, -1, 1};
vector<vector<int>> circle;
int rst = 0;
int Sum() {
	int sum = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			if (circle[i][j] == 0) continue;
			sum += circle[i][j];
		}
	}
	return sum;
}
bool Left() {
	for (int i = 1; i <= N; i++)
		for (int j = 1; j <= M; j++)
			if (circle[i][j] != 0) return true;
	return false;
}
void Find() {
	int sum = 0, cnt = 0;
	vector<pair<int, int>> tmp;
	bool valid = true;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			if (circle[i][j] == 0) continue;
			sum += circle[i][j];
			cnt++;
			for (int t = 0; t < 4; t++) {
				int ni = i + dir[t];
				int nj = (j + dic[t] + M - 1) % M + 1;

				if (ni < 1 || ni > N) continue;
				if (circle[i][j] == circle[ni][nj]) {
					tmp.push_back({ i, j });
					tmp.push_back({ ni, nj });
					valid = false;
				}
			}
		}
	}
	if (valid) { // 같은 수가 없을 때
		if (cnt == 0) return;
		double avg = (double)sum / cnt;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (circle[i][j] == 0) continue;
				if (circle[i][j] > avg) circle[i][j] -= 1;
				else if (circle[i][j] < avg) circle[i][j] += 1;
			}
		}
	}
	else { //같은 수가 있다면
		for (auto a : tmp) {
			if (circle[a.first][a.second] == 0) continue;
			circle[a.first][a.second] = 0;
		}
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M >> T;
	circle.resize(N+1, vector<int>(M+1));
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) cin >> circle[i][j];
	}
	while (T--) {
		cin >> xi >> di >> ki;
		for (int i = xi; i <= N; i += xi) { // 원판 돌리기 -> (0-시계, 1-반시계)
			vector<int> tmp(M + 1);
			if (di == 0) for (int j = 1; j <= M; j++) tmp[(j + ki - 1) % M + 1] = circle[i][j];
			else for (int j = 1; j <= M; j++) tmp[(j - ki + M -1) % M + 1] = circle[i][j];
			for (int j = 1; j <= M; j++) circle[i][j] = tmp[j];
		}
		if (!Left()) rst = 0;
		else {
			Find();
			rst = Sum();
		}
	}
	cout << rst << '\n';
}