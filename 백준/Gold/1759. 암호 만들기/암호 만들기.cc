#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

int L, C;
vector<char> word;
vector<char> result;
vector<char> tmp;
void Password(int idx, int rst)
{
	if (rst == L)
	{
		int cnt1 = 0; // 모음
		int cnt2 = 0; // 자음
		string str = "";
		for (int i = 0; i < result.size(); i++)
		{
			bool valid = false;
			for (int j = 0; j < tmp.size(); j++)
			{
				if (result[i] == tmp[j])
				{
					valid = true;
					break;
				}
			}
			str += result[i];
			if (valid) cnt1++;
			else cnt2++;
		}
		if (cnt1 >= 1 && cnt2 >= 2)
			cout << str << '\n';
	}

	for (int i = idx; i < C; i++)
	{
		result.push_back(word[i]);
		Password(i+1, rst + 1);
		result.pop_back();
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> L >> C;
	word.resize(C);
	for (int i = 0; i < C; i++)
	{
		char c;
		cin >> c;
		word[i] = c;
		if (c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u')
		{
			tmp.push_back(c);
		}
	}
	sort(word.begin(), word.end());

	Password(0, 0);
}