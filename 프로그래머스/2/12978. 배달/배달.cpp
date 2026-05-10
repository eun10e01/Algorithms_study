#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

const int INF = 1e9;

int solution(int N, vector<vector<int>> road, int K) {
    //그래프
    vector<vector<pair<int, int>>> graph(N + 1);

    for (auto& r : road) {
        int a = r[0];
        int b = r[1];
        int c = r[2];

        graph[a].push_back({ b, c });
        graph[b].push_back({ a, c });
    }

    //최단 거리 배열
    vector<int> dist(N + 1, INF);

    //우선순위 큐(거리, 노드)
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    dist[1] = 0;
    pq.push({ 0, 1 });

    while (!pq.empty()) {
        int curDist = pq.top().first;
        int curNode = pq.top().second;
        pq.pop();

        //이미 더 짧은 경로가 있으면 스킵
        if (curDist > dist[curNode]) {
            continue;
        }

        for (auto& next : graph[curNode]) {
            int nextNode = next.first;
            int cost = next.second;

            int newDist = curDist + cost;

            if (newDist < dist[nextNode]) {
                dist[nextNode] = newDist;
                pq.push({ newDist, nextNode });
            }
        }
    }

    //K 이하로 배달 가능한 마을 개수 계산
    int answer = 0;

    for (int i = 1; i <= N; i++) {
        if (dist[i] <= K)
            answer++;
    }

    return answer;
}