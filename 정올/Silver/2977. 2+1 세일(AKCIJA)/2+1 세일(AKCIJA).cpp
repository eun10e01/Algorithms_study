#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<int> price(N);

    long long total = 0;

    for (int i = 0; i < N; i++) {
        cin >> price[i];
        total += price[i];
    }

    sort(price.begin(), price.end(), greater<int>());

    for (int i = 2; i < N; i += 3) {
        total -= price[i];
    }

    cout << total;

    return 0;
}
