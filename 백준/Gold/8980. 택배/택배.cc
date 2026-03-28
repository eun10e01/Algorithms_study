#include <iostream>
#include <vector>
#include <algorithm>
#include <tuple>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, C, M;
	cin >> N >> C >> M;

	vector<tuple<int, int, int>> boxes;
	vector<int> capacity(N - 1);

	int start, end, cnt;
	int ans = 0;

	for (int i = 0; i < M; i++) {
		cin >> start >> end >> cnt;
		
		//배송지 기준 정렬, 배송지가 같으면 출발지 번호가 큰 것 먼저 처리해야 함.(출발지 번호가 큰게 구간이 짧을 가능성이 크기 때문)
		boxes.push_back(make_tuple(end, start, cnt));
	}

	sort(boxes.begin(), boxes.end(), [](auto a, auto b) {
		if (get<0>(a) == get<0>(b)) { //배송지가 같다면
			return get<1>(a) > get<1>(b); //출발지가 큰 번호가 먼저
		}
		return get<0>(a) < get<0>(b); //배송지가 작은것이 먼저
	});

	for (int i = 0; i < capacity.size(); i++) {
		capacity[i] = C;
	}

	for (int i = 0; i < M; i++) {
		tuple<int, int, int> temp = boxes[i];

		int s = get<1>(temp) - 1; //인덱스 번호이기 때문
		int e = get<0>(temp) - 2; //인덱스 번호이고, 구간 용량을 판단하고 있기 때문에 -1을 더 해주어야 함.
		int box_cnt = get<2>(temp);

		int min_capacity = C;

		for (int j = s; j <= e; j++) {
			min_capacity = min(min_capacity, capacity[j]);
		}

		if (box_cnt <= min_capacity) {
			for (int j = s; j <= e; j++) {
				capacity[j] -= box_cnt;
			}

			ans += box_cnt;
		}
		else {
			for (int j = s; j <= e; j++) {
				capacity[j] -= min_capacity;
			}

			ans += min_capacity;
		}
	}

	cout << ans;

	return 0;
}