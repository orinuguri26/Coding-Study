#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
#include <map>
using namespace std;

int N, M;
vector<string> name;
vector<vector<int>> rel;
vector<int> dig;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> N;
    name.resize(N);
    rel.resize(N);
    dig.assign(N, 0);
    for(int i = 0; i < N; i++) cin >> name[i];
    sort(name.begin(), name.end());

    map<string, int> m;
    for(int i = 0; i < N; i++) m[name[i]] = i;
    cin >> M;
    while(M--) {
        string a, b;
        cin >> a >> b;
        int va = m[a];
        int vb = m[b];
        rel[vb].push_back(va);
        dig[va]++;
    }
    for(int i = 0; i < N; i++) sort(rel[i].begin(), rel[i].end());

    int cnt=0;
    vector<string> str;
    for(int i = 0; i < N; i++) {
        if(dig[i] == 0) { 
            cnt++;
            str.push_back(name[i]);
        }
    }
    cout << cnt << '\n';
    for(auto a : str) cout << a << " ";
    cout << '\n';
    
    for(int i = 0; i < N; i++) {
        int childcnt = 0;
        vector<string> tmp;
        for(auto a : rel[i]) {
            if(dig[a] -1 == dig[i]) {
                childcnt++;
                tmp.push_back(name[a]);
            }
        }
        cout << name[i] << " " << childcnt << " ";
        for(auto a : tmp) cout << a << " ";
        cout << '\n';
    }
}