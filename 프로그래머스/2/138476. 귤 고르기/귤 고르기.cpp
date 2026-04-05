#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0;

    map<int, int> kind;

    //귤 크기 별 개수 세기
    for (int i : tangerine) {
        kind[i]++;
    }

    vector<int> cnt;

    //크기 별 개수만 저장
    for (auto p : kind) {
        cnt.push_back(p.second);
    }

    //내림차순 정렬
    sort(cnt.begin(), cnt.end(), greater<int>());

    int sum = 0;

    for (int i : cnt) {
        sum += i;
        answer++;

        if (sum >= k) {
            break;
        }
    }

    return answer;
}