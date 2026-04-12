#include <iostream>
#include <vector>
#include <string>
#include <queue>

using namespace std;

int M, N;
int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };
vector<vector<int>> fiber;
vector<vector<bool>> visited;

bool DFS(int, int);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> M >> N;

	fiber.resize(M, vector<int>(N));
	visited.resize(M, vector<bool>(N));

	for (int i = 0; i < M; i++) {
		string temp;
		cin >> temp;

		for (int j = 0; j < N; j++) {
			fiber[i][j] = temp[j] - '0';
		}
	}

	bool check = false;

	for (int i = 0; i < N; i++) {
		if (fiber[0][i] == 0 && !visited[0][i]) {
			if (DFS(0, i)) {
				cout << "YES";
				return 0;
			}
		}
	}

	if (!check) {
		cout << "NO";
	}

	return 0;
}

bool DFS(int x, int y) {
	if (x == M - 1) {
		return true;
	}

	visited[x][y] = true;

	for (int k = 0; k < 4; k++) {
		int nx = x + dx[k];
		int ny = y + dy[k];
		
		if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
			if (fiber[nx][ny] == 0 && !visited[nx][ny]) {
				if (DFS(nx, ny)) {
					return true;
				}
			}
		}
	}

	return false;
}