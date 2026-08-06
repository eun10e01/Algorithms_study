#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct Student {
    int idx; //학생 번호
    int remain; //남은 피자 조각 수
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    queue<Student> q;
    vector<int> answer(N);

    for (int i = 0; i < N; i++) {
        int x;
        cin >> x;
        q.push({i, x});
    }

    int time = 0;

    while (!q.empty()) {
        Student cur = q.front();
        q.pop();

        time++;
        cur.remain--;

        if (cur.remain == 0) {
            answer[cur.idx] = time;
        }
        else {
            q.push(cur);
        }
    }

    for (int i = 0; i < N; i++) {
        cout << answer[i];
        
        if (i != N - 1) {
            cout << " ";
        }
    }

    return 0;
}
