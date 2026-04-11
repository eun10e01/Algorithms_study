#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	long long n;
	cin >> n;

	long long cnt = (n * (n - 1) * (n - 2)) / 6;

	cout << cnt << endl;
	cout << 3;

	return 0;
}