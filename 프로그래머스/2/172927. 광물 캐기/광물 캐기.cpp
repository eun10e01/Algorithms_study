#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> picks, vector<string> minerals) {
    int answer = 0;

    vector<vector<int>> groups; //{diamond 개수, iron 개수, stone 개수} 저장

    int idx = 0;
    int totalPicks = picks[0] + picks[1] + picks[2];

    //곡괭이 1개로 5개의 광물을 캘 수 있기 때문에, 광물을 5개씩 그룹으로 만들기
    for (int i = 0; i < minerals.size(); i += 5) {
        if (groups.size() == totalPicks) {
            break;
        }

        int d = 0, ir = 0, s = 0;

        for (int j = i; (j < i + 5 && j < minerals.size()); j++) {
            if (minerals[j].compare("diamond") == 0) {
                d++;
            }
            else if (minerals[j].compare("iron") == 0) {
                ir++;
            }
            else {
                s++;
            }
        }

        groups.push_back({ d, ir, s });
    }

    //캐기 어려운 순으로 정렬(돌 곡괭이 기준)
    sort(groups.begin(), groups.end(), [](vector<int>& a, vector<int>& b) {
        int costA = a[0] * 25 + a[1] * 5 + a[2];
        int costB = b[0] * 25 + b[1] * 5 + b[2];
        return costA > costB;
        });

    //다이아 > 철 > 돌 곡괭이 순으로 사용
    for (auto& g : groups) {
        int d = g[0], ir = g[1], s = g[2];

        if (picks[0] > 0) { //다이아 곡괭이
            answer += d * 1 + ir * 1 + s * 1;
            picks[0]--;
        }
        else if (picks[1] > 0) { //철 곡괭이
            answer += d * 5 + ir * 1 + s * 1;
            picks[1]--;
        }
        else { //돌 곡괭이
            answer += d * 25 + ir * 5 + s * 1;
            picks[2]--;
        }
    }

    return answer;
}