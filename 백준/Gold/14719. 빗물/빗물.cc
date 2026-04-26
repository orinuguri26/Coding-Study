#include <vector>
#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int H, W;
vector<int> Left, Right;
vector<int> height;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> H >> W;
	Left.resize(W);
	Right.resize(W);
	height.resize(W);
	for (int i = 0; i < W; i++) cin >> height[i];

	Left[0] = height[0];
	Right[W - 1] = height[W - 1];

	for (int i = 1; i < W; i++) Left[i] = max(Left[i - 1], height[i]);
	for (int i = W - 2; i >= 0; i--) Right[i] = max(Right[i + 1], height[i]);

	int rst = 0;
	for (int i = 0; i < W; i++) rst += min(Left[i], Right[i]) - height[i];

	cout << rst << '\n';
}