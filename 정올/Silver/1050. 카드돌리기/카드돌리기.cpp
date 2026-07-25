#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

//무늬 우선순위 변환
int getSuitRank(char suit) {
    if (suit == 'C') {
        return 0;
    }

    if (suit == 'D') {
        return 1;
    }

    if (suit == 'S') {
        return 2;
    }

    if (suit == 'H') {
        return 3;
    }

    return -1;
}

//숫자 우선순위 변환
int getValueRank(char val) {
    if (val >= '2' && val <= '9') {
        return val - '0';
    }

    if (val == 'T') {
        return 10;
    }

    if (val == 'J') {
        return 11;
    }

    if (val == 'Q') {
        return 12;
    }

    if (val == 'K') {
        return 13;
    }

    if (val == 'A') {
        return 14;
    }

    return -1;
}

//카드 비교
bool compareCards(const string& a, const string& b) {
    int suitA = getSuitRank(a[0]);
    int suitB = getSuitRank(b[0]);

    //무늬가 다르면 무늬 순으로 정렬
    if (suitA != suitB) {
        return suitA < suitB;
    }

    //무늬가 같으면 숫자 순으로 정렬
    int valA = getValueRank(a[1]);
    int valB = getValueRank(b[1]);

    return valA < valB;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    string dealer;

    if (!(cin >> dealer)) {
        return 0;
    }

    vector<vector<string>> hands(4);

    int idx = 0;

    if (dealer == "N") {
        idx = 1;
    }
    else if (dealer == "E") {
        idx = 2;
    }
    else if (dealer == "S") {
        idx = 3;
    }
    else if (dealer == "W") {
        idx = 0;
    }

    for (int i = 0; i < 2; i++) {
        string cards;
        cin >> cards;

        for (int j = 0; j < 52; j += 2) {
            string card = cards.substr(j, 2);
            hands[idx].push_back(card);
            idx = (idx + 1) % 4; //시계방향 순회
        }
    }

    //카드 정렬
    for (int i = 0; i < 4; i++) {
        sort(hands[i].begin(), hands[i].end(), compareCards);
    }

    int printOrder[4] = { 2, 3, 0, 1 };
    char labels[4] = { 'N', 'E', 'S', 'W' };

    for (int i = 0; i < 4; i++) {
        int playerIdx = printOrder[i];
        cout << labels[playerIdx] << ": ";

        for (int j = 0; j < 13; j++) {
            cout << hands[playerIdx][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
