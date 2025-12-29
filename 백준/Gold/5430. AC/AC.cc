#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int T;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> T;
	while (T--)
	{
		string str;
		cin >> str;

		int n;
		cin >> n;

		string arr;
		cin >> arr;

		int cnt = 0;

		deque<string> rst;
		for (int i = 0; i < arr.size(); i++)
		{
			if (arr[i] == '[') continue;
			if (arr[i] == ',' || arr[i] == ']')
			{
				if (arr[i] == ']' && arr[i - 1] == '[') continue;
				string tmp;
				for (int j = cnt; j > 0; j--) tmp += arr[i - j];
				rst.push_back(tmp);
				cnt = 0;
				continue;
			}
			cnt++;
		}
		bool valid = true;
		bool rvs = false;
		for (int i = 0; i < str.size(); i++)
		{
			if (str[i] == 'R')
			{
				rvs = !rvs;
			}
			else
			{
				if (rst.empty())
				{
					cout << "error" << '\n';
					valid = false;
					break;
				}
				if (rvs)
					rst.pop_back();
				else
					rst.pop_front();
			}
		}
		if (rvs) reverse(rst.begin(), rst.end());
		if (valid)
		{
			cout << "[";
			for (int i = 0; i < rst.size(); i++)
			{
				if (i + 1 == rst.size())
				{
					cout << rst[i];
				}
				else
				cout << rst[i] << ",";
			}
			cout << "]" << '\n';
		}
	}
}