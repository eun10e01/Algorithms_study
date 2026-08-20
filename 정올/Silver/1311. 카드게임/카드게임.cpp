#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<char> color(5);
    vector<int> num(5);

    int cnt[10] = {0};

    for (int i = 0; i < 5; i++) {
        cin >> color[i] >> num[i];
        cnt[num[i]]++;
    }

    vector<int> sorted = num;
    sort(sorted.begin(), sorted.end());

    bool sameColor = true;
    for (int i = 1; i < 5; i++) {
        if (color[i] != color[0]) {
            sameColor = false;
            break;
        }
    }

    bool consecutive = true;
    for (int i = 1; i < 5; i++) {
        if (sorted[i] != sorted[i - 1] + 1) {
            consecutive = false;
            break;
        }
    }

    int maxNum = sorted[4];

    if (sameColor && consecutive) {
        cout << 900 + maxNum;
        return 0;
    }

    for (int i = 1; i <= 9; i++) {
        if (cnt[i] == 4) {
            cout << 800 + i;
            return 0;
        }
    }

    int three = 0, two = 0;

    for (int i = 1; i <= 9; i++) {
        if (cnt[i] == 3) three = i;
        if (cnt[i] == 2) two = i;
    }

    if (three != 0 && two != 0) {
        cout << 700 + three * 10 + two;
        return 0;
    }

    if (sameColor) {
        cout << 600 + maxNum;
        return 0;
    }

    if (consecutive) {
        cout << 500 + maxNum;
        return 0;
    }

    for (int i = 1; i <= 9; i++) {
        if (cnt[i] == 3) {
            cout << 400 + i;
            return 0;
        }
    }

    vector<int> pairs;

    for (int i = 1; i <= 9; i++) {
        if (cnt[i] == 2) {
            pairs.push_back(i);
        }
    }

    if (pairs.size() == 2) {
        int big = max(pairs[0], pairs[1]);
        int small = min(pairs[0], pairs[1]);

        cout << 300 + big * 10 + small;
        return 0;
    }

    for (int i = 1; i <= 9; i++) {
        if (cnt[i] == 2) {
            cout << 200 + i;
            return 0;
        }
    }

    cout << 100 + maxNum;

    return 0;
}
