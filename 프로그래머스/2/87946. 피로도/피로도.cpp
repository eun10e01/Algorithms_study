#include <string>
#include <vector>

using namespace std;

int maxDepth = 0;
bool visited[8] = {false,};

void DFS(int depth, int power, vector<vector<int>> &dungeons){
    if(maxDepth < depth){
        maxDepth = depth;
    }
    
    for(int i = 0; i < dungeons.size(); i++){
        if(visited[i] || dungeons[i][0] > power){
            continue;
        }
        
        visited[i] = true;
        DFS(depth + 1, power - dungeons[i][1], dungeons);
        visited[i] = false;
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    DFS(0, k, dungeons);
    
    return maxDepth;
}