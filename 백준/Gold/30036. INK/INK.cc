#include <iostream>
#include <algorithm>
#include <map>
#include <vector>
#include <string>
#include <cmath>
using namespace std;

//30036 INK
int I, N, K;
vector<char> color;
vector<vector<char>> stage;
pair<int, int> start;
vector<pair<int, int>> obstacle;
int m = 0; //잉크 양
int cnt = 0; //점프 수
void Move(char c) {
	int nr = 0, nc = 0;
	switch (c) {
	case 'U': {
		nr = start.first - 1;
		nc = start.second;
		break;
	}
	case 'D': {
		nr = start.first + 1;
		nc = start.second;
		break;
	}
	case 'L': {
		nr = start.first;
		nc = start.second - 1;
		break;
	}
	case 'R': {
		nr = start.first;
		nc = start.second + 1;
		break;
	}
	default: return;
	}
	if (nr < 0 || nr >= N || nc < 0 || nc >= N) return;
	if (stage[nr][nc] != '.') return;
	start = { nr, nc };
}
void Command(char c) {
	switch (c) {
	case 'j': {
		m += 1;
		break;
	}
	case 'J': {
		for (int i = 0; i < obstacle.size(); i++) {
			int y = obstacle[i].first;
			int x = obstacle[i].second;

			int a = abs(start.first - y);
			int b = abs(start.second - x);
			if (a + b <= m) {
				stage[y][x] = color[cnt];
			}
		}
		cnt = (cnt + 1) % I;
		m = 0;
		break;
	}
	default: {
		Move(c);
		break;
	}
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> I >> N >> K;
	stage.resize(N, vector<char>(N));
	color.resize(I);
	string str;
	cin >> str;
	for (int i = 0; i < I; i++) color[i] = str[i];
	for (int i = 0; i < N; i++) {
		cin >> str;
		for (int j = 0; j < N; j++) {
			stage[i][j] = str[j];
			if (str[j] == '@') {
				start = { i,j }; 
				stage[i][j] = '.';
			}
			if (str[j] == '#') obstacle.push_back({ i,j });
		}
	}
	cin >> str;
	for (int i = 0; i < K; i++) Command(str[i]);

	stage[start.first][start.second] = '@';
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cout << stage[i][j];
		}
		cout << '\n';
	}
}