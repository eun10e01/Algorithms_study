#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Interval {
    int start;
    int end;
};

bool cmp(const Interval& a, const Interval& b) {
    return a.start < b.start;
}

int getCoveredTime(const vector<Interval>& intervals, int remove) {
    vector<Interval> remaining;

    for (int i = 0; i < intervals.size(); i++) {
        if (i == remove) continue;

        remaining.push_back(intervals[i]);
    }

    sort(remaining.begin(), remaining.end(), cmp);

    if (remaining.empty()) {
        return 0;
    }

    int total = 0;

    int currentStart = remaining[0].start;
    int currentEnd = remaining[0].end;

    for (int i = 1; i < remaining.size(); i++) {
        int nextStart = remaining[i].start;
        int nextEnd = remaining[i].end;

        if (nextStart <= currentEnd) {
            currentEnd = max(currentEnd, nextEnd);
        }
        else {
            total += currentEnd - currentStart;

            currentStart = nextStart;
            currentEnd = nextEnd;
        }
    }

    total += currentEnd - currentStart;

    return total;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    vector<Interval> intervals(N);

    for (int i = 0; i < N; i++) {
        cin >> intervals[i].start >> intervals[i].end;
    }

    int answer = 0;

    for (int remove = 0; remove < N; remove++) {
        int coveredTime = getCoveredTime(intervals, remove);

        answer = max(answer, coveredTime);
    }

    cout << answer << '\n';

    return 0;
}
