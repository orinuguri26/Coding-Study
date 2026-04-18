#include <iostream>
#include <algorithm>
#include <map>
#include <vector>
#include <string>
using namespace std;

int N;
struct Node {
	map<string, Node*> child;
};
Node* root = new Node();
void InputNode(vector<string> path) {
	Node* cur = root;
	for (auto p : path) {
		if (cur->child.find(p) == cur->child.end())
			cur->child[p] = new Node();
		cur = cur->child[p];
	}
}
void DFS(Node* node, int depth) {
	for (auto next : node->child) {
		for (int i = 0; i < depth; i++) cout << " ";
		cout << next.first << '\n';
		DFS(next.second, depth + 1);
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N;
	while (N--) {
		string str;
		cin >> str;
		vector<string> path;
		string tmp = "";
		for (int i = 0; i < str.length(); i++) {
			if (str[i] == '\\') {
				path.push_back(tmp);
				tmp = "";
			}
			else {
				tmp += str[i];
			}
		}
		path.push_back(tmp);
		tmp = "";

		InputNode(path);
	}
	DFS(root, 0);
}