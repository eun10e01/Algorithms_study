#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

    int N;
    cin >> N;

    long long ans = 0;

    //c : 가장 긴 변
    for (int c = 1; c <= (N - 1) / 2; c++) {
        int S = N - c; //a + b
        int low = max(1, N - 2 * c);
        int high = S / 2; //a <= b

        if (low <= high)
            ans += (high - low + 1);
    }

    cout << ans << '\n';
    return 0;
}
