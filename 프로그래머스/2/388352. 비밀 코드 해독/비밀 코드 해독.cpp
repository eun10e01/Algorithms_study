#include <string>
#include <vector>

using namespace std;

int answer = 0;
vector<vector<int>> questionVector;
vector<int> answerVector;
int num;

//두 배열에서 겹치는 숫자의 개수 계산
int countMatch(vector<int> comb, vector<int> q) {
    int cnt = 0;

    for (int i : comb) { //comb의 각 숫자 i에 대해
        for (int j : q) {
            if (i == j) { //q안에 i와 같은 숫자가 있다면
                cnt++;
                break;
            }
        }
    }

    return cnt;
}

//가능한 모든 숫자 조합 생성
void DFS(int start, vector<int> comb) {
    if (comb.size() == 5) { //숫자 5개를 뽑았다면 검사 시작
        for (int i = 0; i < questionVector.size(); i++) { //모든 질문에 대해
            if (countMatch(comb, questionVector[i]) != answerVector[i]) { //겹치는 개수가 ans와 같은지 확인
                return;
            }
        }

        answer++; //겹치는 개수가 ans와 같다면 가능한 코드이므로 answer에 1을 더한다.
        return;
    }

    //start부터 n까지 숫자를 선택 >> 하나를 넣고 재귀를 호출한다. >> 끝나면 다시 뺀다.
    for (int i = start; i <= num; i++) {
        comb.push_back(i);
        DFS(i + 1, comb);
        comb.pop_back();
    }
}

int solution(int n, vector<vector<int>> q, vector<int> ans) {
    num = n;
    questionVector = q;
    answerVector = ans;

    vector<int> combination;

    DFS(1, combination);

    return answer;
}