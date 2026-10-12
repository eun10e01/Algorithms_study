
#include <string>
#include <cstdlib>

using namespace std;

string solution(int n, int m, int x, int y, int r, int c, int k) {
    int dist = abs(x - r) + abs(y - c);

    //남은 이동 횟수로 목적지까지 갈 수 없거나, 홀짝이 맞지 않는 경우
    if (dist > k || (k - dist) % 2 != 0) {
        return "impossible";
    }

    string answer = "";

    int dx[4] = {1, 0, 0, -1};
    int dy[4] = {0, -1, 1, 0};
    char dir[4] = {'d', 'l', 'r', 'u'};

    for (int i = 0; i < k; ++i) {
        for (int j = 0; j < 4; ++j) {
            int nx = x + dx[j];
            int ny = y + dy[j];

            //격자 밖으로 나가는 경우
            if (nx < 1 || nx > n || ny < 1 || ny > m) {
                continue;
            }

            //다음 위치에서 목적지까지의 최단 거리
            int nextDist = abs(nx - r) + abs(ny - c);

            //남은 이동 횟수
            int remain = k - i - 1;

            //남은 횟수 안에 목적지 도달이 가능한지 확인
            if (nextDist > remain || (remain - nextDist) % 2 != 0) {
                continue;
            }

            //가능한 방향 중 사전순으로 가장 빠른 방향 선택
            answer += dir[j];
            x = nx;
            y = ny;
            break;
        }
    }

    return answer;
}