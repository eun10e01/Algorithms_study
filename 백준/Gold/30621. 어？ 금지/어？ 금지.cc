#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	vector<long long> t(N);
	vector<long long> b(N);
	vector<long long> c(N);

	vector<long long> DP(N + 1);

	for (int i = 0; i < N; i++) {
		cin >> t[i];
	}

	for (int i = 0; i < N; i++) {
		cin >> b[i];
	}

	for (int i = 0; i < N; i++) {
		cin >> c[i];
	}

	DP[0] = 0;
	DP[1] = c[0];

	for (int i = 2; i <= N; i++) {
		long long idx = lower_bound(t.begin(), t.end(), t[i - 1] - b[i - 1]) - t.begin();
		//t[j] < t[i] - b[i]를 만족하는 마지막 j를 idx로 함.

		DP[i] = max(DP[idx] + c[i - 1], DP[i - 1]);
		//현재 idx시각에 어?를 외친 경우와, 외치지 않은 경우를 비교해 더 큰 값을 DP테이블에 채움.
	}

	cout << DP[N];

	return 0;
}