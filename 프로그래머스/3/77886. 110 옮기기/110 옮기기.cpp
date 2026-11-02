#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> s) {
    vector<string> answer;

    for (string str : s) {
        string remain;
        int count110 = 0;

        for (char c : str) {
            remain += c;

            int n = remain.size();

            if (n >= 3 && remain[n - 3] == '1' && remain[n - 2] == '1' && remain[n - 1] == '0') {
                remain.resize(n - 3);
                count110++;
            }
        }

        int pos = remain.rfind('0');

        string result = remain.substr(0, pos + 1);

        for (int i = 0; i < count110; i++) {
            result += "110";
        }

        result += remain.substr(pos + 1);

        answer.push_back(result);
    }

    return answer;
}