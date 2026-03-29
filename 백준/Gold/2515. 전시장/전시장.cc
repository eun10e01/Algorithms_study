#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int N, S;
	cin >> N >> S;

	int H, C;
	int sum_C = 0;
	
	vector<int> DP(N); //i번째 그림을 마지막 그림으로 선택했을 때 최대 가격합
	vector<int> max_DP(N);
	vector<pair<int, int>> pictures;

	for (int i = 0; i < N; i++) {
		cin >> H >> C;
		pictures.push_back(make_pair(H, C));
	}

	sort(pictures.begin(), pictures.end(), [](auto a, auto b) {
		if (get<0>(a) == get<0>(b)) { //H가 같다면
			return get<1>(a) > get<1>(b); //C가 큰 것이 먼저
		}
		return get<0>(a) < get<0>(b); //H가 작은것이 먼저
		});

	int idx = -1;

	for (int i = 0; i < N; i++) {
		H = get<0>(pictures[i]);
		C = get<1>(pictures[i]);

		int target = H - S;
		int left = 0;
		int right = i - 1;
		
		while (left <= right) {
			int mid = (left + right) / 2;

			int temp = get<0>(pictures[mid]);

			if (temp <= target) {
				idx = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}

		DP[i] = C; //초기값은 i번째 그림 한개만 선택하는 경우

		if (idx != -1) {
			DP[i] = C + max_DP[idx];
		}

		if (i == 0) {
			max_DP[i] = DP[i];
		}
		else {
			max_DP[i] = max(max_DP[i - 1], DP[i]);
		}
	}

	cout << max_DP[N - 1];
}