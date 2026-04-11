#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M, card;
	cin >> N >> M;

	vector<int> cards;

	for (int i = 0; i < N; i++) {
		cin >> card;

		cards.push_back(card);
	}

	int sum = 0;

	for (int i = 0; i < N; i++) {
		for (int j = i + 1; j < N; j++) {
			for (int k = j + 1; k < N; k++) {
				int temp = cards[i] + cards[j] + cards[k];

				if (temp <= M && temp > sum) {
					sum = temp;
				}
			}
		}
	}

	cout << sum;

	return 0;
}