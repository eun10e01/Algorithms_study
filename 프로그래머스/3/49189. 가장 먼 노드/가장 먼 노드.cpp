#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int solution(int n, vector<vector<int>> vertex) {
    //그래프
    vector<vector<int>> graph(n + 1);

    for (auto& v : vertex) {
        int a = v[0];
        int b = v[1];

        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    //거리
    vector<int> dist(n + 1, -1);

    queue<int> q;

    dist[1] = 0;
    q.push(1);

    //BFS
    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        for (int next : graph[cur]) {
            //아직 방문하지 않은 노드라면
            if (dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                q.push(next);
            }
        }
    }

    //가장 먼 거리 찾기
    int maxDist = *max_element(dist.begin(), dist.end());

    //가장 먼 노드 개수 세기
    int answer = 0;

    for (int d : dist) {
        if (d == maxDist) {
            answer++;
        }
    }

    return answer;
}