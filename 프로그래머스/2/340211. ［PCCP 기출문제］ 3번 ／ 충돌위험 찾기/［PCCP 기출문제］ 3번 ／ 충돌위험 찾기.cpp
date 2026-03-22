#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

int solution(vector<vector<int>> points, vector<vector<int>> routes) {
    int answer = 0;
    int n = routes.size();

    vector<vector<int>> cur(n, vector<int>(2)); //현재 위치
    vector<int> idx(n, 0); //각 로봇이 현재 몇 번째 route인지
    vector<bool> finished(n, false); //완전히 종료
    vector<bool> will_finish(n, false); //이번 1초가 끝나고 종료 예정(마지막에 같은 위치에서 동시에 끝나는지 여부 판단을 위함.)

    //초기 위치
    for (int i = 0; i < n; i++) {
        int start = routes[i][0] - 1;
        cur[i] = points[start];
        idx[i] = 1;
    }

    //맨 처음에 같은 위치에서 시작하는지 체크
    map<pair<int, int>, int> m;

    for (int i = 0; i < n; i++) {
        m[{cur[i][0], cur[i][1]}]++;
    }
    for (auto& it : m) {
        if (it.second >= 2) {
            answer++;
        }
    }

    while (true) {
        bool all_done = true;

        //이동
        for (int i = 0; i < n; i++) {
            if (finished[i]) continue;

            all_done = false;

            int target = routes[i][idx[i]] - 1;
            int tr = points[target][0];
            int tc = points[target][1];

            if (cur[i][0] != tr) {
                if (cur[i][0] < tr) cur[i][0]++;
                else cur[i][0]--;
            }
            else if (cur[i][1] != tc) {
                if (cur[i][1] < tc) {
                    cur[i][1]++;
                }
                else {
                    cur[i][1]--;
                }
            }

            if (cur[i][0] == tr && cur[i][1] == tc) {
                idx[i]++;

                if (idx[i] == routes[i].size()) {
                    will_finish[i] = true; //이번의 1초가 끝나고 제외 될 예정이다.
                }
            }
        }

        if (all_done) {
            break;
        }

        //충돌 체크
        map<pair<int, int>, int> m;

        for (int i = 0; i < n; i++) {
            if (finished[i]) {
                continue;
            }

            m[{cur[i][0], cur[i][1]}]++;
        }

        for (auto& it : m) {
            if (it.second >= 2) {
                answer++;
            }
        }

        //이번 1초 후 로봇 완전히 제외
        for (int i = 0; i < n; i++) {
            if (will_finish[i]) {
                finished[i] = true;
                will_finish[i] = false;
            }
        }
    }

    return answer;
}