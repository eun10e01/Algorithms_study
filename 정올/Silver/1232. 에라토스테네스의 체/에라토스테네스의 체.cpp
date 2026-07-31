#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, K;
    cin >> N >> K;
    
    vector<bool> isRemoved(N + 1, false);

    int count = 0;

    for (int i = 2; i <= N; i++) {
        if (!isRemoved[i]) { //아직 지워지지 않은 가장 작은 소수를 발견했을 때
            for (int j = i; j <= N; j += i) {
                if (!isRemoved[j]) { //그 수(i)부터 시작하여 i의 배수들을 순서대로 제거
                    isRemoved[j] = true;
                    count++;

                    if (count == K) {
                        cout << j << "\n";
                        return 0;
                    }
                }
            }
        }
    }

    return 0;
}
