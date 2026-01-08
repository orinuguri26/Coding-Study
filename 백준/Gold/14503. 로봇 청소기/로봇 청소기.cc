#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

//14503 로봇청소기
int N, M;
vector<vector<int>> room;
vector<vector<bool>> clean;
int dir[4] = { -1, 0, 1, 0 }; //북동남서
int dic[4] = { 0, 1, 0, -1 };
int cnt = 0;

struct state
{
	int row;
	int col;
	int pos;
};
void CleanUp(int r, int c, int d)
{
	int fr = r;
	int fc = c;
	int fd = d;

	bool active = true;
	while (1)
	{
		if (!clean[fr][fc]) {
			clean[fr][fc] = true;
			cnt++;
		}
		bool isClean = true; //true면 주변이 다 깨끗함, false면 더러운데 있음

		for (int i = 4; i > 0; i--) //사방 청소X 탐색
		{
			int idx = (fd + i - 1) % 4;
			int nr = fr + dir[idx];
			int nc = fc + dic[idx];

			if (room[nr][nc] == 1) continue; //주변이 벽이면 넘겨
			if (!clean[nr][nc]) //주변에 청소 안한곳이 있음
			{
				isClean = false;
			}
		}

		if (isClean) //전부 깨끗이라면
		{
			if (room[fr - dir[fd]][fc - dic[fd]] == 1) // 후진이 벽이면
			{
				active = false;
				break; //작동 정지
			}
			fr = fr - dir[fd];
			fc = fc - dic[fd];
			fd = fd;
		}
		else //안깨끗한데가 있다면
		{
			for (int i = 4; i > 0; i--) //사방 청소X 탐색
			{
				int idx = (fd + i - 1) % 4;
				int nr = fr + dir[idx];
				int nc = fc + dic[idx];
				int nd = idx;

				if (room[nr][nc] == 1) continue; //주변이 벽이면 넘겨
				if (!clean[nr][nc]) //주변에 청소 안한곳이 있음
				{
					fr = nr;
					fc = nc;
					fd = nd;

					break;
				}
			}
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M;
	state first;
	cin >> first.row >> first.col >> first.pos;

	room.resize(N, vector<int>(M));
	clean.assign(N, vector<bool>(M, false));
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> room[i][j]; //1은 벽, 0은 더러움
		}
	}
	CleanUp(first.row, first.col, first.pos);
	cout <<  cnt << '\n';
}