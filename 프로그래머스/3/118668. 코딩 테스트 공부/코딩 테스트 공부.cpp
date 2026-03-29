#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int alp, int cop, vector<vector<int>> problems) {
    int answer = 0;

    int alp_max = 0;
    int cop_max = 0;

    //달성해야 하는 alp, cop값
    for (int i = 0; i < problems.size(); i++) {
        vector<int> problem = problems[i];

        alp_max = max(alp_max, problem[0]);
        cop_max = max(cop_max, problem[1]);
    }

    //초기 alp, cop값이 목표값보다 클 경우를 대비.
    alp = min(alp, alp_max);
    cop = min(cop, cop_max);

    vector<vector<int>> DP(alp_max + 1, vector<int>(cop_max + 1, 1e9)); //최소 시간 DP, DP 테이블의 크기: (alp_max + 1) * (cop_max + 1), 초기값: 1e9
    DP[alp][cop] = 0; //시작하는 위치의 DP 테이블 값을 0으로 초기화.

    for (int i = alp; i <= alp_max; i++) {
        for (int j = cop; j <= cop_max; j++) {
            if (i + 1 <= alp_max) { //alp_max값을 넘지 않는 선에서 alp를 1만큼 공부한 경우(max를 넘는 공부는 쓸모 없음.)
                DP[i + 1][j] = min(DP[i + 1][j], DP[i][j] + 1); //기존에 alp+1, cop를 달성하기 위해 필요한 최소 시간과 지금 시간에서 공부+1을 했을 때의 시간을 비교하여 최소 값을 DP 테이블에 넣는다.
            }

            if (j + 1 <= cop_max) { //cop_max값을 넘지 않는 선에서 cop를 1만큼 공부한 경우(max를 넘는 공부는 쓸모 없음.)
                DP[i][j + 1] = min(DP[i][j + 1], DP[i][j] + 1); //기존에 alp, cop+1를 달성하기 위해 필요한 최소 시간과 지금 시간에서 공부+1을 했을 때의 시간을 비교하여 최소 값을 DP 테이블에 넣는다.
            }

            for (auto& p : problems) {
                int req_alp = p[0];
                int req_cop = p[1];
                int rwd_alp = p[2];
                int rwd_cop = p[3];
                int cost = p[4];

                if (i >= req_alp && j >= req_cop) { //현재 alp값과 cop값으로 문제를 풀 수 있는 경우
                    int next_i = min(alp_max, i + rwd_alp); //목표값과 (현재 alp + 문제를 풀고 받을 수 있는 alp)를 비교하여 더 작은 값을 next_i로 함.(max를 넘는 공부는 쓸모 없음.)
                    int next_j = min(cop_max, j + rwd_cop); //목표값과 (현재 cop + 문제를 풀고 받을 수 있는 cop)를 비교하여 더 작은 값을 next_j로 함.(max를 넘는 공부는 쓸모 없음.)

                    DP[next_i][next_j] = min(DP[next_i][next_j], DP[i][j] + cost);
                    //문제를 풀고 난 다음의 최소 시간을 DP 테이블에 원래 들어있던 기존 최소 시간과 (문제를 풀기 전의 최소 시간 + 문제 풀이 시간)을 비교하여 더 작은 값으로 함.
                }
            }
        }
    }

    answer = DP[alp_max][cop_max];

    return answer;
}