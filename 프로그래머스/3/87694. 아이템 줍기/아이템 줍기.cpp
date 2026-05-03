#include <string>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

void DFS(int, int, int, int, int);

int visited[101][101];
int answer = INT_MAX;
int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };

int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {
    characterX *= 2;
    characterY *= 2;
    itemX *= 2;
    itemY *= 2;

    for (int i = 0; i < rectangle.size(); i++) {
        for (int x = rectangle[i][0] * 2; x <= rectangle[i][2] * 2; x++) {
            for (int y = rectangle[i][1] * 2; y <= rectangle[i][3] * 2; y++) {
                visited[x][y] = 7;
            }
        }
    }

    for (int i = 0; i < rectangle.size(); i++) {
        for (int x = rectangle[i][0] * 2 + 1; x <= rectangle[i][2] * 2 - 1; x++) {
            for (int y = rectangle[i][1] * 2 + 1; y <= rectangle[i][3] * 2 - 1; y++) {
                visited[x][y] = 0;
            }
        }
    }

    visited[characterX][characterY] = 1;
    
    DFS(characterX, characterY, itemX, itemY, 0);

    return answer / 2;
}

void DFS(int x, int y, int ansX, int ansY, int cnt) {
    if (x == ansX && y == ansY) {
        answer = min(answer, cnt);
        return;
    }

    for (int i = 0; i < 4; i++) {
        if (visited[x + dx[i]][y + dy[i]] == 7) {
            visited[x + dx[i]][y + dy[i]] = 0;

            DFS(x + dx[i], y + dy[i], ansX, ansY, cnt + 1);

            visited[x + dx[i]][y + dy[i]] = 7;
        }
    }
}