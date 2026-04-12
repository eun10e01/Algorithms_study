#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<vector<int>> edges) {
    vector<int> answer;

    vector<int> in(1000001);
    vector<int> out(1000001);

    vector<bool> exist(1000001, false);

    for (auto e : edges) {
        exist[e[0]] = true;
        exist[e[1]] = true;
    }

    for (auto e : edges) {
        out[e[0]]++;
        in[e[1]]++;
    }

    int start = 0;

    //생성된 노드 탐색
    for (int i = 1; i < 1000001; i++) {
        if (in[i] == 0 && out[i] >= 2) {
            start = i;
            break;
        }
    }

    //생성된 노드의 간선 제거
    for (auto e : edges) {
        if (e[0] == start) {
            in[e[1]]--;
        }
    }

    int stick = 0; //막대
    int eight = 0; //8자
    int donut = 0; //도넛

    for (int i = 1; i < 1000001; i++) {
        if (!exist[i] || i == start) {
            continue;
        }

        if (in[i] == 0) {
            stick++;
        }

        if (in[i] == 2) {
            eight++;
        }
    }

    int total = out[start];
    donut = total - stick - eight;

    answer.push_back(start);
    answer.push_back(donut);
    answer.push_back(stick);
    answer.push_back(eight);

    return answer;
}