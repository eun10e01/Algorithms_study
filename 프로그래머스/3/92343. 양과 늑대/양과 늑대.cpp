#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void DFS(int, int, int);

vector<int> node[20];
vector<int> state;
int answer = 0;
bool visited[20][20][20];

int solution(vector<int> info, vector<vector<int>> edges) {
    for (auto e : edges) {
        node[e[0]].push_back(e[1]);
        node[e[1]].push_back(e[0]);
    }

    state = info;

    state[0] = -1;
    visited[0][1][0] = true;

    DFS(0, 1, 0);

    return answer;
}

void DFS(int current, int sheep, int wolf) {
    if (current == 0) {
        answer = max(answer, sheep);
    }

    for (auto next : node[current]) {
        if (state[next] == 0) {
            if (visited[next][sheep + 1][wolf] == false) {
                visited[next][sheep + 1][wolf] = true;
                state[next] = -1;

                DFS(next, sheep + 1, wolf);

                state[next] = 0;
                visited[next][sheep + 1][wolf] = false;
            }
        }
        else if (state[next] == 1) {
            if (visited[next][sheep][wolf + 1] == false && sheep > wolf + 1) {
                visited[next][sheep][wolf + 1] = true;
                state[next] = -1;
                
                DFS(next, sheep, wolf + 1);

                state[next] = 1;
                visited[next][sheep][wolf + 1] = false;
            }
        }
        else {
            if (visited[next][sheep][wolf] == false) {
                visited[next][sheep][wolf] = true;

                DFS(next, sheep, wolf);

                visited[next][sheep][wolf] = false;
            }
        }
    }
}