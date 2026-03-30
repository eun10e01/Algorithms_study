#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	long A;
	long sum = 0;

	for (int i = 0; i < 5; i++) {
		cin >> A;
		sum += A;
	}

	cout << sum;

	return 0;
}