#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

void DFS(int, int, vector<int>, vector<vector<pair<int, int>>>&);
    
int answer = 0;
vector<bool> visited;

int solution(int n, int infection, vector<vector<int>> edges, int k) {
	vector<vector<pair<int, int>>> e(n + 1);

	for (int i = 0; i < edges.size(); ++i)
	{
		e[edges[i][0]].push_back(make_pair(edges[i][1], edges[i][2]));
		e[edges[i][1]].push_back(make_pair(edges[i][0], edges[i][2]));
	}

	visited.assign(n + 1, false);

	visited[infection] = true;
	DFS(0, k, { infection }, e);

	return answer;
}

void DFS(int current, int k, vector<int> curInfection, vector<vector<pair<int, int>>>& edges) {
	if (current == k) {
		answer = max(answer, (int)curInfection.size());
		return;
	}

	for (int i = 1; i < 4; i++) {
		int temp;
		vector<int> add;
		vector<int> next = curInfection;
		queue<int> q;

		for (int j = 0; j < curInfection.size(); j++) {
			q.push(curInfection[j]);
		}

		while (!q.empty()) {
			temp = q.front();
			q.pop();

			for (int j = 0; j < edges[temp].size(); j++) {
				if (!visited[edges[temp][j].first] && (edges[temp][j].second == i)) {
					visited[edges[temp][j].first] = true;

					add.push_back(edges[temp][j].first);
					next.push_back(edges[temp][j].first);

					q.push(edges[temp][j].first);
				}
			}
		}

		DFS(current + 1, k, next, edges);

		for (int j = 0; j < add.size(); j++) {
			visited[add[j]] = false;
		}
	}
}