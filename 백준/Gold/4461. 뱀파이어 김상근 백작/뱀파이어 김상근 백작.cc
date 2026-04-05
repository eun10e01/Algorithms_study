#include <iostream>
#include <climits>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;

	while (true) {
		cin >> n;

		if (n == 0) {
			break;
		}

		long long ansA = 0, ansB = 0, ansC = 0;
		long long min = LLONG_MAX;

		for (int b = 1; b < 4000; b++) {
			long long maxAC = 4000 - 2 * b;
			
			if (maxAC <= 0) {
				break;
			}

			//(c/b)^3 = n - (a/b)^3
			for (int a = 1; a < maxAC; a++) {
				long long temp = 1LL * n * b * b * b - 1LL * a * a * a;

				if (temp <= 0) {
					continue;
				}

				long long left = 0;
				long long right = 2000000; //적당히 큰 수
				long long c = -1;

				while (left <= right) {
					long long mid = (left + right) / 2;
					long long target = mid * mid * mid;

					if (target == temp) {
						c = mid;
						break;
					}
					else if (target < temp) {
						left = mid + 1;
					}
					else {
						right = mid - 1;
					}
				}

				if (c == -1) {
					continue;
				}

				if (a < c) {
					continue;
				}

				long long sum = a + c + 2LL * b;

				if (sum < 4000 && sum < min) {
					min = sum;
					ansA = a;
					ansB = b;
					ansC = c;
				}
			}
		}

		if (min == LLONG_MAX) {
			cout << "No value." << endl;
		}
		else {
			cout << "(" << ansA << "/" << ansB << ")^3 + (" << ansC << "/" << ansB << ")^3 = " << n << endl;
		}
	}

	return 0;
}