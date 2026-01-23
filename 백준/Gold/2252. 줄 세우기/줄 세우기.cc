#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int N, M, A, B;
vector<vector<int>> student;
vector<int> height;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M;
	student.resize(N + 1); //관계도
	height.assign(N + 1, 0); //차수

	while (M--)
	{
		cin >> A >> B;
		student[A].push_back(B);
		height[B]++;
	}
	queue<int> q;
	for (int i = 1; i <= N; i++)
	{
		if (height[i] != 0) continue;
		q.push(i);
	}
	while (!q.empty())
	{
		int fh = q.front();
		q.pop();

		cout << fh << " ";

		for (auto a : student[fh])
		{
			height[a]--;
			if (height[a] != 0) continue;
			q.push(a);
		}
	}
}