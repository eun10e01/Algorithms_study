#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
	  cin.tie(NULL);

    long long n;
    cin >> n;

    long long left = 1;
    long long right = 2000000000LL;

    //이분탐색
    while (left < right) {
        long long mid = left + (right - left) / 2;
        long long sum = mid * (mid + 1) / 2;

        if (sum >= n) {
            right = mid;
        }
        else {
            left = mid + 1;
        }
    }

    cout << left;

    return 0;
}
