#include <iostream>
#include <vector>
#include <set>
#include <cmath>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        int n;
        cin >> n;

        vector<int> a(n);

        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }

        set<vector<int>> visited;

        while (true) {
            bool allZero = true;

            for (int x : a) {
                if (x != 0) {
                    allZero = false;
                    break;
                }
            }

            if (allZero) {
                cout << "ZERO\n";
                break;
            }

            if (visited.count(a)) {
                cout << "LOOP\n";
                break;
            }

            visited.insert(a);

            vector<int> next(n);

            for (int i = 0; i < n; i++) {
                next[i] = abs(a[i] - a[(i + 1) % n]);
            }

            a = next;
        }
    }

    return 0;
}
