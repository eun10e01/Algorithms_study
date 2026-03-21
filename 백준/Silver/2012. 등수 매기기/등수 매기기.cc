#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	long long ans = 0;

	cin >> N;

	vector<int> rank(N);

	for (int i = 0; i < N; i++) {
		cin >> rank[i];
	}

	sort(rank.begin(), rank.end());

	for (int i = 0; i < N; i++) {
		ans += abs(rank[i] - (i + 1));
	}

	cout << ans;

	return 0;
}