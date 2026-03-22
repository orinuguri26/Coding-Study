#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int N, M;
int h, w;
vector<vector<int>> bodo;
int K;
vector<pair<int, int>> hasugu;
int dir[4] = { -1, 1, 0, 0 };
int dic[4] = { 0, 0, -1, 1 };
vector<vector<bool>> visited;
vector<vector<int>> sum;
void BFS(int sr, int sc) {
	queue<pair<int, int>> q;
	q.push({ sr, sc });
	visited[sr][sc] = true;

	while (!q.empty()) {
		int fr = q.front().first;
		int fc = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nr = fr + dir[i];
			int nc = fc + dic[i];
			if (nr < 1 || nr > N || nc < 1 || nc > M) continue;
			if (bodo[nr][nc] < bodo[fr][fc]) continue;
			if (!visited[nr][nc]) {
				q.push({ nr, nc });
				visited[nr][nc] = true;
			}
		}
	}
}
int getSum(int r1, int c1, int r2, int c2) {
	return sum[r2][c2] - sum[r1 - 1][c2]- sum[r2][c1 - 1]+ sum[r1 - 1][c1 - 1];
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M;
	cin >> h >> w;
	bodo.resize(N + 1, vector<int>(M + 1));
	visited.assign(N + 1, vector<bool>(M + 1, false));
	sum.assign(N + 1, vector<int>(M + 1, 0));

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) cin >> bodo[i][j];
	}
	cin >> K;
	for (int i = 0; i < K; i++) {
		int a, b;
		cin >> a >> b;
		hasugu.push_back({ a,b });
	}
	for (auto a : hasugu) {
		BFS(a.first, a.second);
	}

	vector<vector<int>> board(N + 1, vector<int>(M + 1));
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			if (visited[i][j]) board[i][j] = 0;
			else board[i][j] = 1;
		}
	}
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			sum[i][j] = board[i][j]+ sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
		}
	}

	int rst = 0;
	for (int i = h; i <= N; i++) {
		for (int j = w; j <= M; j++) {
			int sum = getSum(i - h + 1, j - w + 1, i, j);

			if (sum == 0) rst++;
		}
	}
	cout << rst << '\n';
}