
#include <string>
#include <vector>
#include <unordered_map>
#include <sstream>

using namespace std;

int toDays(string date) {
    int year = stoi(date.substr(0, 4));
    int month = stoi(date.substr(5, 2));
    int day = stoi(date.substr(8, 2));

    return year * 12 * 28 + month * 28 + day;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    unordered_map<string, int> period;

    //약관 종류별 유효기간 저장
    for (string term : terms) {
        string type;
        int months;

        stringstream ss(term);
        ss >> type >> months;

        period[type] = months;
    }

    int todayDays = toDays(today);

    //개인정보별 만료일 확인
    for (int i = 0; i < privacies.size(); ++i) {
        string date, type;

        stringstream ss(privacies[i]);
        ss >> date >> type;

        int expireDays = toDays(date) + period[type] * 28;

        //만료일 당일부터 파기
        if (todayDays >= expireDays) {
            answer.push_back(i + 1);
        }
    }

    return answer;
}