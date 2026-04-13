#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <climits>

using namespace std;

void dijkstra(int[], int);
int n, m, t; //교차로, 도로, 목적지 후보 개수
int s, g, h; //s: 예술가 출발지, g와 h 사이 도로를 지나감
vector<vector<pair<int, int>>> graph(2001);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> n >> m >> t;
		cin >> s >> g >> h;
		graph.assign(2001, vector<pair<int, int>>());

		for (int i = 0; i < m; i++) {
			int a, b, d;
			cin >> a >> b >> d;

			graph[a].push_back(make_pair(b, d));
			graph[b].push_back(make_pair(a, d));
		}

		vector<int> end;

		for (int i = 0; i < t; i++) {
			int x; //목적지 후보
			cin >> x;

			end.push_back(x);
		}

		int distS[2001], distG[2001], distH[2001]; //distS: s>x까지의 최단 거리, distG: g>x까지의 최단 거리, distH: h>x까지의 최단 거리

		dijkstra(distS, s);
		dijkstra(distG, g);
		dijkstra(distH, h);

		vector<int> ans;

		for (int x : end) {
			int path1 = distS[g] + distG[h] + distH[x]; //s>g>h>x
			int path2 = distS[h] + distH[g] + distG[x]; //s>h>g>x

			//목적지(x)까지의 최단거리 == 위의 두 경로 중 하나라면
			if (distS[x] == path1 || distS[x] == path2) {
				ans.push_back(x);
			}
		}

		sort(ans.begin(), ans.end());

		for (int x : ans) {
			cout << x << " ";
		}

		cout << "\n";
	}

	return 0;
}

void dijkstra(int dist[], int start) {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq; //오름차순

	//거리 초기화
	for (int i = 1; i <= n; i++) {
		dist[i] = INT_MAX;
	}

	dist[start] = 0;
	pq.push(make_pair(0, start));

	while (!pq.empty()) {
		int cost = pq.top().first; //현재까지 거리
		int now = pq.top().second; //현재 노드
		pq.pop();

		if (dist[now] < cost) { //더 짧은 경로로 현재 노드(now)에 도달한 적이 있다면 무시
			continue;
		}

		for (auto next : graph[now]) {
			int nextNode = next.first; //이동할 노드
			int nextCost = next.second; //가중치

			if (dist[nextNode] > cost + nextCost) { //지금까지 알고 있던 거리보다 더 짧은 경로 발견 시 값 갱신
				dist[nextNode] = cost + nextCost;
				pq.push(make_pair(dist[nextNode], nextNode));
			}
		}
	}
}