#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<vector<long long>> S(N, vector<long long>(N));

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> S[i][j];
        }
    }

    vector<long long> A(N);

    if (N >= 3) {
        A[0] = (S[0][1] + S[0][2] - S[1][2]) / 2;

        for (int i = 1; i < N; i++) {
            A[i] = S[0][i] - A[0];
        }
    }

    for (int i = 0; i < N; i++) {
        cout << A[i];
        if (i + 1 < N) cout << ' ';
    }

    return 0;
}
