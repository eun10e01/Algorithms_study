#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    int current = 0;
    int answer = 0;

    for (int i = 0; i < N; i++) {
        int x;
        cin >> x;

        current = max(0, current + x);

        answer = max(answer, current);
    }

    cout << answer;

    return 0;
}
