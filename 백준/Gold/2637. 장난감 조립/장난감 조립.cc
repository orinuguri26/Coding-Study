#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int N, M;
vector<int> parts;
vector<vector<pair<int, int>>> composer;
vector<int> rst;
vector<bool> base;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> N;
    cin >> M;
    parts.resize(N+1);
    composer.resize(N+1);
    rst.resize(N+1);
    base.assign(N+1, false);
    rst[N] = 1;

    for(int i = 0; i < M; i++) {
        int X, Y, Z;
        cin >> X >> Y >> Z;
        composer[X].push_back({Y, Z});
        parts[Y]++;
        base[X] = true;
    }

    queue<int> q;
    q.push(N);
    while(!q.empty()) {
        int fp = q.front();
        q.pop();

        for(auto a : composer[fp]) {
            rst[a.first] += a.second * rst[fp];
            parts[a.first]--;

            if(parts[a.first] == 0) q.push(a.first);
        }
    }
    for(int i = 1; i <= N; i++) {
        if(base[i]) continue;
        cout << i << ' ' << rst[i] << '\n';
    }
}