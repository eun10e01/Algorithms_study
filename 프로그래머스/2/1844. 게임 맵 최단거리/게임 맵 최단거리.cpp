#include <vector>
#include <queue>

using namespace std;

struct Point{
    int x, y, count;
};

int dx[4] = {0, 1, 0, -1};
int dy[4] = {-1, 0, 1, 0};
int m, n;

bool check_range(int x, int y){
    return x >= 0 && x < m && y >= 0 && y < n;
}

int BFS(vector<int> start, vector<int> end, vector<vector<int>> &maps){
    bool visited[101][101] = {false};
    queue<Point> q;
    
    q.push({start[0], start[1], 1});
    visited[start[0]][start[1]] = true;
    
    while(!q.empty()){
        Point current = q.front();
        q.pop();
        
        if(current.x == end[0] && current.y == end[1]){
            return current.count;
        }
        
        for(int i = 0; i < 4; i++){
            int nx = current.x + dx[i];
            int ny = current.y + dy[i];
            
            if(check_range(nx, ny) && !visited[nx][ny] && maps[nx][ny] != 0){
                q.push({nx, ny, current.count + 1});
                visited[nx][ny] = true;
            }
        }
    }
    
    return -1;
}

int solution(vector<vector<int>> maps) {
    int answer = 0;
    
    m = maps.size();
    n = maps[0].size();
    
    int distance = BFS({0, 0}, {m - 1 , n - 1}, maps);
    
    if(distance == -1){
        return -1;
    }
    else{
        answer = distance;
    }
    
    return answer;
}