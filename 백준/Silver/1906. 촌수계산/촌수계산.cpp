#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    int a, b;
    cin >> a >> b;

    int m;
    cin >> m;

    vector<vector<int>> graph(n + 1);

    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;

        //부모와 자식은 서로 연결되어 있으므로 양방향
        graph[x].push_back(y);
        graph[y].push_back(x);
    }

    vector<int> dist(n + 1, -1);
    queue<int> q;

    //시작 사람
    dist[a] = 0;
    q.push(a);

    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        for (int next : graph[cur]) {
            //아직 방문하지 않은 사람
            if (dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                q.push(next);
            }
        }
    }

    cout << dist[b];

    return 0;
}
