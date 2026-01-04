#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

vector<vector<int>> sdoku(9, vector<int>(9));
vector<vector<bool>> row(9, vector<bool>(10, false));
vector<vector<bool>> col(9, vector<bool>(10, false));
vector<vector<bool>> sec(9, vector<bool>(10, false));
vector<pair<int, int>> num;
void Fill(int idx)
{
	if (idx >= num.size())
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				cout << sdoku[i][j];
			}
			cout << '\n';
		}
		exit(0);
	}
	int r = num[idx].first;
	int c = num[idx].second;
	int s = (r / 3) * 3 + (c / 3);

	for (int i = 1; i <= 9; i++)
	{
		if (row[r][i]) continue;
		if (col[c][i]) continue;
		if (sec[s][i]) continue;

		sdoku[r][c] = i;
		row[r][i] = true;
		col[c][i] = true;
		sec[s][i] = true;

		Fill(idx + 1);

		sdoku[r][c] = 0;
		row[r][i] = false;
		col[c][i] = false;
		sec[s][i] = false;
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (int i = 0; i < 9; i++)
	{
		string str;
		cin >> str;
		for (int j = 0; j < 9; j++)
		{
			sdoku[i][j] = str[j] - '0';
			if(sdoku[i][j] == 0)
			{
				num.push_back({i,j});
				continue;
			}
			row[i][sdoku[i][j]] = true;
			col[j][sdoku[i][j]] = true;
			sec[(i / 3) * 3 + (j / 3)][sdoku[i][j]] = true;
		}
	}
	Fill(0);
}