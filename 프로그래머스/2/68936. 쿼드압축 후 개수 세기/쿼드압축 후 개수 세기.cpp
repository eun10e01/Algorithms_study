#include <vector>

using namespace std;

vector<int> answer(2, 0);

void compress(const vector<vector<int>>& arr, int x, int y, int size) {
    int value = arr[x][y];
    bool same = true;

    for (int i = x; i < x + size; i++) {
        for (int j = y; j < y + size; j++) {
            if (arr[i][j] != value) {
                same = false;
                break;
            }
        }
        if (!same) break;
    }

    if (same) {
        answer[value]++;
        return;
    }

    int half = size / 2;

    compress(arr, x, y, half);
    compress(arr, x, y + half, half);
    compress(arr, x + half, y, half);
    compress(arr, x + half, y + half, half);
}

vector<int> solution(vector<vector<int>> arr) {
    answer = {0, 0};

    compress(arr, 0, 0, arr.size());

    return answer;
}