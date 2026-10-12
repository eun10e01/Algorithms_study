
#include <string>
#include <vector>

using namespace std;

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
    long long answer = 0;

    int d = n - 1;
    int p = n - 1;

    while (d >= 0 || p >= 0) {
        //배달할 집 중 가장 먼 집 찾기
        while (d >= 0 && deliveries[d] == 0) {
            --d;
        }

        //수거할 집 중 가장 먼 집 찾기
        while (p >= 0 && pickups[p] == 0) {
            --p;
        }

        //이번 왕복에서 도달해야 하는 가장 먼 거리
        answer += 2LL * (max(d, p) + 1);

        int capacity = cap;

        //배달 처리
        while (d >= 0 && capacity > 0) {
            if (deliveries[d] <= capacity) {
                capacity -= deliveries[d];
                deliveries[d] = 0;
                --d;
            } else {
                deliveries[d] -= capacity;
                capacity = 0;
            }
        }

        capacity = cap;

        //수거 처리
        while (p >= 0 && capacity > 0) {
            if (pickups[p] <= capacity) {
                capacity -= pickups[p];
                pickups[p] = 0;
                --p;
            }
            else {
                pickups[p] -= capacity;
                capacity = 0;
            }
        }
    }

    return answer;
}