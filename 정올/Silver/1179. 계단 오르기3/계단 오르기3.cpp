#include <iostream>
#include <vector>

using namespace std;

const int MOD = 1000000007;
int dp[50005];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

	dp[0] = 1;
	dp[1] = 1;
    dp[2] = 1;

	for (int i = 3; i <= n; i++) {
		dp[i] = (dp[i - 2] + dp[i - 3]) % MOD;
	}

	cout << dp[n];

    return 0;
}
