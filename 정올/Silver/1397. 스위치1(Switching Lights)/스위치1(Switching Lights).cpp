#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M;
    cin >> N >> M;

    vector<int> light(N + 1, 0);

    for (int i = 0; i < M; i++) {
        int command, S, E;
        cin >> command >> S >> E;

        if (command == 0) {
            for (int j = S; j <= E; j++) {
                light[j] = 1 - light[j];
            }
        }
        else {
            int count = 0;

            for (int j = S; j <= E; j++) {
                if (light[j] == 1) {
                    count++;
                }
            }

            cout << count << '\n';
        }
    }

    return 0;
}
