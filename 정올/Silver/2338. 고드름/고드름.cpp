#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Icicle {
    int length;
    int index;
};

int main() {
    ios::sync_with_stdio(false);
	cin.tie(NULL);

    int N, L;
    cin >> N >> L;

    vector<int> a(N);

    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }

    vector<Icicle> order(N); //길이가 긴 고드름부터 처리

    for (int i = 0; i < N; i++) {
        order[i] = {a[i], i};
    }

    sort(order.begin(), order.end(), [](const Icicle& x, const Icicle& y) {
        return x.length > y.length;
    });

    vector<long long> breakTime(N, 0); //i번 고드름이 부러지는 시간

    long long answer = 0;

    for (const auto& icicle : order) {
        int i = icicle.index;

        long long startTime = 0; //i번 고드름이 자라기 시작하는 시간

        if (i - 1 >= 0 && a[i - 1] > a[i]) {
            startTime = max(startTime, breakTime[i - 1]);
        }

        if (i + 1 < N && a[i + 1] > a[i]) {
            startTime = max(startTime, breakTime[i + 1]);
        }

        breakTime[i] = startTime + (L - a[i]); //시작한 후 L까지 자라는 데 걸리는 시간

        answer = max(answer, breakTime[i]);
    }

    cout << answer;

    return 0;
}
