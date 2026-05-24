#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

const int INF = 1e9;
vector<vector<int>> dp; //dp[i][j]: A의 관광 날짜 i, B의 관광 날짜 j에서의 최소 비용
vector<bool> visited_A, visited_B;

int N;
int p1, p3, p5, ppair;

void update_a(int i, int j) {
    dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + p1);

    for (int k = 1; k <= 3; k++) {
        dp[i + k][j] = min(dp[i + k][j], dp[i][j] + p3);
    }
    for (int k = 1; k <= 5; k++) {
        dp[i + k][j] = min(dp[i + k][j], dp[i][j] + p5);
    }
}

void update_b(int i, int j) {
    dp[i][j + 1] = min(dp[i][j + 1], dp[i][j] + p1);

    for (int k = 1; k <= 3; k++) {
        dp[i][j + k] = min(dp[i][j + k], dp[i][j] + p3);
    }
    for (int k = 1; k <= 5; k++) {
        dp[i][j + k] = min(dp[i][j + k], dp[i][j] + p5);
    }
}

void update_ppair(int i, int j) {
    for (int a = 0; a <= 4; a++) {
        for (int b = 0; b <= 4; b++) {
            dp[i + a][j + b] = min(dp[i + a][j + b], dp[i][j] + ppair);
        }
    }
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;

    string A, B;
    cin >> A >> B;

    cin >> p1 >> p3 >> p5 >> ppair;

    visited_A.resize(N + 2, false);
    visited_B.resize(N + 2, false);
    dp.resize(N + 6, vector<int>(N + 6, INF));

    for (int i = 1; i <= N; i++) {
        if (A[i - 1] == '1') {
            visited_A[i] = true;
        }
        if (B[i - 1] == '1') {
            visited_B[i] = true;
        }
    }

    dp[0][0] = 0; //0일은 존재하지 않음.

    for (int i = 1; i <= N + 1; i++) {
        bool check_A = visited_A[i];
        for (int j = 1; j <= N + 1; j++) {
            bool check_B = visited_B[j];

            //X
            if (!check_A) {
                dp[i][j - 1] = min(dp[i][j - 1], dp[i - 1][j - 1]);
            }    
            if (!check_B) {
                dp[i - 1][j] = min(dp[i - 1][j], dp[i - 1][j - 1]);
            }

            //O
            if (check_A) {
                update_a(i - 1, j - 1);
            }
            if (check_B) {
                update_b(i - 1, j - 1);
            }

            //i == j >> 묶음권 사용
            if (i == j) {
                update_ppair(i - 1, j - 1);
            }
        }
    }

    cout << dp[N][N];

    return 0;
}
