#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<pair<long long, long long>> student(N);

    for (int i = 0; i < N; i++) {
        cin >> student[i].first >> student[i].second;
    }

    int groups = 0;
    long long groupSpeed = 0;

    //맨 앞 학생부터 그룹을 만든다고 생각하기 위해 뒤에서부터 확인
    for (int i = N - 1; i >= 0; i--) {
        long long speed = student[i].second;

        if (groups == 0 || speed <= groupSpeed) {
            groups++;
            groupSpeed = speed;
        }
        //speed > groupSpeed 이면 앞 그룹을 따라잡으므로 같은 그룹
    }

    cout << groups;

    return 0;
}
