#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int a1, a0, c, n0;
	cin >> a1 >> a0 >> c >> n0;

	int f = a1 * n0 + a0;
	int cg = c * n0;

	if (c < a1 || f > cg) {
		cout << 0;
		return 0;
	}

	cout << 1;

	return 0;
}