#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int a, b, c, d, e, f;
	cin >> a >> b >> c >> d >> e >> f;

	int f1, f2;

	for (int i = -999; i <= 999; i++) {
		for (int j = -999; j <= 999; j++) {
			f1 = a * i + b * j;
			f2 = d * i + e * j;

			if (f1 == c && f2 == f) {
				cout << i << " " << j;
				return 0;
			}
		}
	}

	return 0;
}