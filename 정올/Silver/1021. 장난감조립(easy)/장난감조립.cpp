#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M; //N: 완제품 번호, M: 부품들 간의 관계 개수
int indegree[101]; //각 부품을 만들기 위해 필요한 하위 부품의 수
vector<pair<int, int>> adj[101]; //그래프 (Y -> {X, K})
int needs[101][101]; //needs[i][j]: i번 부품을 만들기 위해 필요한 j번 기본 부품의 개수
bool isBasic[101]; //기본 부품 여부 판별

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int X, Y, K;
		cin >> X >> Y >> K; //중간 부품이나 완제품 X를 만드는데 필요한 중간 부품 혹은 기본 부품 Y가 K개 필요함.

		adj[Y].push_back({ X, K }); //Y번 부품이 K개 있어야 X번 부품을 만들 수 있다.
		indegree[X]++; //X를 만드는 데 재료가 하나 더 추가되므로 진입 차수 증가
	}

	queue<int> q;

	//진입 차수가 0인 부품(기본 부품) 찾기
	for (int i = 1; i <= N; i++) {
		if (indegree[i] == 0) {
			q.push(i);
			isBasic[i] = true; //기본 부품임을 표시
			needs[i][i] = 1; //기본 부품인 자기 자신은 1개 필요하다고 설정
		}
	}

	//위상 정렬
	while (!q.empty()) {
		int current = q.front();
		q.pop();

		//current 부품을 재료로 사용하는 상위 부품(next) 확인
		for (auto& edge : adj[current]) {
			int next = edge.first;
			int count = edge.second;

			//current를 만드는 데 들어간 모든 기본 부품들의 개수에 count를 곱해 next에 누적
			for (int i = 1; i <= N; i++) {
				if (needs[current][i] > 0) {
					needs[next][i] += needs[current][i] * count;
				}
			}

			indegree[next]--; //진입 차수 감소

			//진입 차수가 0이 되면 큐에 삽입
			if (indegree[next] == 0) {
				q.push(next);
			}
		}
	}

	//완제품 N을 만드는 데 필요한 기본 부품만 출력
	for (int i = 1; i <= N; i++) {
		if (isBasic[i]) {
			cout << i << " " << needs[N][i] << "\n";
		}
	}

	return 0;
}
