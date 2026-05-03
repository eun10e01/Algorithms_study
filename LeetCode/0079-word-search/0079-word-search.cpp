#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size();
        int n = board[0].size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //DFS 시작
                if (DFS(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    bool DFS(vector<vector<char>>& board, string& word, int x, int y, int depth) {
        //단어의 모든 글자를 찾은 경우
        if (depth == word.length()) {
            return true;
        }

        //경계 조건 및 현재 문자가 일치하지 않는 경우
        if (x < 0 || x >= board.size() || y < 0 || y >= board[0].size() || board[x][y] != word[depth]) {
            return false;
        }

        //임시로 값을 변경하여 방문 처리
        char temp = board[x][y];
        board[x][y] = '#';

        //상하좌우 탐색
        bool found = DFS(board, word, x + 1, y, depth + 1) || DFS(board, word, x - 1, y, depth + 1) || DFS(board, word, x, y + 1, depth + 1) || DFS(board, word, x, y - 1, depth + 1);

        //원상 복구(백트래킹)
        board[x][y] = temp;

        return found;
    }
};