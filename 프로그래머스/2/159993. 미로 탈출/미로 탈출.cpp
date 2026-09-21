#include <string>
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

Point findStartPoint(char start, vector<string> &maps){
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(maps[i][j] == start){
                return {i, j, 0};
            }
        }
    }
    
    return {-1, -1, -1};
}

int BFS(char start, char end, vector<string> &maps){
    bool visited[101][101] = {false};
    queue<Point> q;
    
    q.push(findStartPoint(start, maps));
    
    while(!q.empty()){
        Point current = q.front();
        q.pop();
        
        if(maps[current.x][current.y] == end){
            return current.count;
        }
        
        for(int i = 0; i < 4; i++){
            int nx = current.x + dx[i];
            int ny = current.y + dy[i];
            
            if(check_range(nx, ny) && !visited[nx][ny] && maps[nx][ny] != 'X'){
                q.push({nx, ny, current.count + 1});
                visited[nx][ny] = true;
            }
        }
    }
    
    return -1;
}

int solution(vector<string> maps) {
    int answer = 0;
    
    m = maps.size();
    n = maps[0].size();
    
    int distanceSL = BFS('S', 'L', maps);
    
    if(distanceSL == -1){
        return -1;
    }
    
    int distanceLE = BFS('L', 'E', maps);
    
    if(distanceLE == -1){
        return -1;
    }
    else{
        answer = distanceSL + distanceLE;
    }
    
    return answer;
}