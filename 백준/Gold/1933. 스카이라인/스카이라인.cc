#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <queue>
#include <map>
using namespace std;

int N;
struct cmp
{
	bool operator()(pair<int, int>a, pair<int, int> b)
	{
		if (a.first == b.first) return a.second < b.second;
		return a.first > b.first;
	}
};
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> pq;
	map<int, int> sky;
	while (N--)
	{
		int L, H, R;
		cin >> L >> H >> R;
		pq.push({ L, H });
		pq.push({ R, -H });
	}

	int Height = 0;
	while (!pq.empty())
	{
		int fL = pq.top().first;
		while (!pq.empty() && pq.top().first == fL)
		{
			int fH = pq.top().second;
			pq.pop();

			if (fH > 0) sky[fH]++;
			else
			{
				fH = abs(fH);
				sky[fH]--;
				if (sky[fH] == 0) sky.erase(fH);
			}
		}

		int nHeight = sky.empty() ? 0 : sky.rbegin()->first; //map이 비어있으면 높이0, 아니면 젤 높은거
		if (Height != nHeight)
		{
			cout << fL << " " << nHeight << " ";
			Height = nHeight;
		}
	}
}