#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	vector<pair<int, int>> points;

	for (int i = 0; i < N; i++) {
		int x, y;
		cin >> x >> y;

		points.push_back(make_pair(x, y));
	}

	sort(points.begin(), points.end(), [](auto a, auto b) {
		if (a.second == b.second) {
			return a.first < b.first;
		}
		return a.second < b.second;
	});

	for (int i = 0; i < N; i++) {
		cout << points[i].first << " " << points[i].second << "\n";
	}

	return 0;
}