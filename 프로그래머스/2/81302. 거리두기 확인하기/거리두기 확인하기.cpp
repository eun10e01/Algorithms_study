
#include <string>
#include <vector>
using namespace std;

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;

    int dr[] = {-1, 1, 0, 0};
    int dc[] = {0, 0, -1, 1};

    for (int p = 0; p < 5; p++) {
        bool valid = true;

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (places[p][r][c] != 'P')
                    continue;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5)
                        continue;

                    // 거리 1에 응시자가 있으면 위반
                    if (places[p][nr][nc] == 'P') {
                        valid = false;
                        break;
                    }

                    // 거리 2에 응시자가 있는지 확인
                    int nnr = r + dr[d] * 2;
                    int nnc = c + dc[d] * 2;

                    if (nnr >= 0 && nnr < 5 && nnc >= 0 && nnc < 5) {
                        if (places[p][nnr][nnc] == 'P' &&
                            places[p][nr][nc] != 'X') {
                            valid = false;
                            break;
                        }
                    }
                }

                if (!valid) break;

                // 대각선 확인
                for (int i = -1; i <= 1; i += 2) {
                    for (int j = -1; j <= 1; j += 2) {
                        int nr = r + i;
                        int nc = c + j;

                        if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5)
                            continue;

                        if (places[p][nr][nc] == 'P') {
                            if (places[p][r][nc] != 'X' ||
                                places[p][nr][c] != 'X') {
                                valid = false;
                                break;
                            }
                        }
                    }

                    if (!valid) break;
                }

                if (!valid) break;
            }

            if (!valid) break;
        }

        answer.push_back(valid ? 1 : 0);
    }

    return answer;
}