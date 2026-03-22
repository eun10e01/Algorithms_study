#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int K;
	cin >> K;

	vector<int> nums;

	for (int i = 0; i < K; i++) {
		int temp;
		cin >> temp;

		if (temp == 0) {
			nums.pop_back();
		}
		else {
			nums.push_back(temp);
		}
	}

	int sum = 0;

	for (int i : nums) {
		sum += i;
	}

	cout << sum;

	return 0;
}