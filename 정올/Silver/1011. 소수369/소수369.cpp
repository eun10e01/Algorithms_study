#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M, K;
    cin >> N >> M >> K;

    vector<bool> isPrime(M + 1, true);

    if (M >= 0) {
        isPrime[0] = false;
    }

    if (M >= 1) {
        isPrime[1] = false;
    }

    for (int i = 2; i * i <= M; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= M; j += i) {
                isPrime[j] = false;
            }
        }
    }
    
    int ans = 0;

    for (int i = 2; i <= M; i++) {
        if (isPrime[i]) {
            int player = (i - 1) % N;

            if (player == K) {
                ans++;
            }
        }
    }

    cout << ans;

    return 0;
}
