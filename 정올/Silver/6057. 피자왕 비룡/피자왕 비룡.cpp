#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int P, N;
    cin >> P >> N;

    queue<int> pizza[51];
    long long money = 0;

    for (int i = 0; i < N; i++) {
        int cmd, p;
        cin >> cmd >> p;

        if (cmd == 0) {
            int m;
            cin >> m;
            pizza[p].push(m);
        }
        else {
            if (!pizza[p].empty()) {
                money += pizza[p].front();
                pizza[p].pop();
            }
        }
    }

    cout << money;

    return 0;
}
