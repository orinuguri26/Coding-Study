#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

int N;
vector<long long> liquid;
long long Min;
vector<long long> rst;
void Find(vector<long long> vec)
{
	int left = 0;
	int right = vec.size() - 1;
	Min = abs(vec[left] + vec[right]);
	long long rstleft = vec[left];
	long long rstright = vec[right];

	while (left < right)
	{
		if (vec[left] + vec[right] == 0)
		{
			rstleft = vec[left];
			rstright = vec[right];
			break;
		}
		else if (vec[left] + vec[right] < 0)
		{
			if(Min > abs(vec[left] + vec[right]))
			{
				Min = abs(vec[left] + vec[right]);
				rstleft = vec[left];
				rstright = vec[right];
			}
			left++;
		}
		else
		{
			if (Min > abs(vec[left] + vec[right]))
			{
				Min = abs(vec[left] + vec[right]);
				rstleft = vec[left];
				rstright = vec[right];
			}
			right--;
		}
	}
	cout << rstleft << " " << rstright;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	liquid.resize(N);
	for (int i = 0; i < N; i++) cin >> liquid[i];

	sort(liquid.begin(), liquid.end());

	Find(liquid);
}