#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    priority_queue<int> max_heap;
    priority_queue<int, vector<int>, greater<int>> min_heap;

    if (M == 1) {
        for (int i = 0; i < N; i++) {
            int num;
            cin >> num;

            min_heap.push(num);
        }

        for (int i = 0; i < N; i++) {
            cout << min_heap.top() << "\n";
            min_heap.pop();
        }
    }
    else {
        for (int i = 0; i < N; i++) {
            int num;
            cin >> num;

            max_heap.push(num);
        }

        for (int i = 0; i < N; i++) {
            cout << max_heap.top() << "\n";
            max_heap.pop();
        }
    }

    return 0;
}
