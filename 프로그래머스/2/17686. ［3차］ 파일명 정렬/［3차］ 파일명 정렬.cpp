#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(vector<string> files) {
    vector<string> answer;

    vector<tuple<string, int, string>> sorting;
    //head, number, 원래 파일명

    for (int i = 0; i < files.size(); i++) {
        string temp = files[i];
        string head = "";
        string numStr = "";

        for (char c : temp) {
            if (isdigit(c)) {
                numStr += c;
            }
            else {
                if (numStr.empty()) {
                    head += c;
                }
                else {
                    break;
                }
            }
        }

        // 대소문자를 구분하지 않음.
        transform(head.begin(), head.end(), head.begin(), [](unsigned char c) {
            return tolower(c);
        });

        int number = stoi(numStr);

        sorting.push_back(make_tuple(head, number, temp));
    }

    stable_sort(sorting.begin(), sorting.end(), [](const auto& a, const auto& b) {
        if (get<0>(a) != get<0>(b)) {
            return get<0>(a) < get<0>(b);
        }
        return get<1>(a) < get<1>(b);
    });

    for (auto& x : sorting) {
        answer.push_back(get<2>(x));
    }

    return answer;
}