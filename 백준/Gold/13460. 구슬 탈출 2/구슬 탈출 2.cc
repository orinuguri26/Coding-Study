#include <string>
#include <vector>
#include <iostream>
#include <cmath>
#include <climits>
#include <algorithm>
#include <queue>
using namespace std;

int N, M;
pair<int, int> red, blue;
vector<vector<char>> board;
vector<vector<vector<vector<bool>>>> visited;
int dir[4] = { -1, 1, 0, 0 };
int dic[4] = { 0, 0, -1, 1 };
struct state {
	int Rr, Rc, Br, Bc, cnt;
};
void BFS(pair<int, int> R, pair<int, int> B) {
	queue<state> q;
	q.push({ R.first, R.second, B.first, B.second, 0 });
	visited[R.first][R.second][B.first][B.second] = true;

	while (!q.empty()) {
		int fRr = q.front().Rr;
		int fRc = q.front().Rc;
		int fBr = q.front().Br;
		int fBc = q.front().Bc;
		int fcnt = q.front().cnt;
		q.pop();

		if (fcnt >= 10) continue;

		for (int i = 0; i < 4; i++) {
			int nRr = fRr;
			int nRc = fRc;
			int nBr = fBr;
			int nBc = fBc;
			int Rcnt = 0, Bcnt = 0; //빨구, 파구 이동거리

			while (board[nRr + dir[i]][nRc + dic[i]] != '#' && board[nRr][nRc] != 'O') {
				nRr += dir[i];
				nRc += dic[i];
				Rcnt++;
			} //빨간구슬 이동
			while (board[nBr + dir[i]][nBc + dic[i]] != '#' && board[nBr][nBc] != 'O') {
				nBr += dir[i];
				nBc += dic[i];
				Bcnt++;
			} //파란구슬 이동

			if (board[nBr][nBc] == 'O') continue;
			if (board[nRr][nRc] == 'O') {
				cout << fcnt + 1 << '\n';
				return;
			}
			if (nRr == nBr && nRc == nBc) {
				if (Rcnt > Bcnt) {
					nRr -= dir[i];
					nRc -= dic[i];
				}
				else {
					nBr -= dir[i];
					nBc -= dic[i];
				}
			}
			if (!visited[nRr][nRc][nBr][nBc]) {
				q.push({ nRr, nRc, nBr, nBc, fcnt + 1 });
				visited[nRr][nRc][nBr][nBc] = true;
			}
		}
	}
	cout << -1 << '\n';
	return;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M;
	board.resize(N, vector<char>(M));
	visited.assign(N, vector<vector<vector<bool>>>(M, vector<vector<bool>>(N, vector<bool>(M, false))));
	for (int i = 0; i < N; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < str.size(); j++) {
			board[i][j] = str[j];
			if (str[j] == 'R') red = { i,j };
			if (str[j] == 'B') blue = { i,j };
		}
	}
	BFS(red, blue);
}