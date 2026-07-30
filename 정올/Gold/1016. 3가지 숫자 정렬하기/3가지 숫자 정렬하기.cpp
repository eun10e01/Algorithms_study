#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> a(N);

    int cnt[4] = {0};

    for (int i = 0; i < N; i++) {
        cin >> a[i];
        cnt[a[i]]++;
    }

    int end1 = cnt[1];
    int end2 = cnt[1] + cnt[2];

    int mis[4][4] = {0};

    for (int i = 0; i < N; i++) {
        int section;
        if (i < end1) section = 1;
        else if (i < end2) section = 2;
        else section = 3;

        mis[section][a[i]]++;
    }

    int ans = 0;

    for (int i = 1; i <= 3; i++) {
        for (int j = i + 1; j <= 3; j++) {
            int x = min(mis[i][j], mis[j][i]);

            ans += x;

            mis[i][j] -= x;
            mis[j][i] -= x;
        }
    }

    int remain = 0;

    for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= 3; j++) {
            if (i != j) {
                remain += mis[i][j];
            }
        }
    }

    ans += (remain / 3) * 2;

    cout << ans;
    return 0;
}
