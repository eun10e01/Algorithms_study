#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <set>
#include <map>

using namespace std;

int getCardValue(char c) {
    if (c >= '2' && c <= '9') {
        return c - '0';
    }
    if (c == 'T') {
        return 10;
    }
    if (c == 'J') {
        return 11;
    }
    if (c == 'Q') {
        return 12;
    }
    if (c == 'K') {
        return 13;
    }
    if (c == 'A') {
        return 14;
    }

    return 0;
}

bool isRoyalFlush(vector<string> cards) {
    set<char> values;
    set<char> suits;

    for (int i = 0; i < 5; i++) {
        values.insert(cards[i][0]);
        suits.insert(cards[i][1]);
    }

    if (suits.size() != 1) {
        return false;
    }

    if (values.size() != 5) {
        return false;
    }
    else {
        if (values.contains('A') && values.contains('K') && values.contains('Q') && values.contains('J') && values.contains('T')) {
            return true;
        }
        else {
            return false;
        }
    }
}

bool isStraightFlush(vector<string> cards) {
    set<int> values;
    set<char> suits;

    for (int i = 0; i < 5; i++) {
        values.insert(getCardValue(cards[i][0]));
        suits.insert(cards[i][1]);
    }

    if (suits.size() != 1) {
        return false;
    }

    if (values.size() != 5) {
        return false;
    }
    else {
        int min = *values.begin();
        int max = *values.rbegin();

        if (max - min == 4) {
            return true;
        }
        else if (values.contains(14) && values.contains(2) && values.contains(3) && values.contains(4) && values.contains(5)) {
            return true;
        }
        else {
            return false;
        }
    }
}

bool isFourOfAKind(vector<string> cards) {
    map<char, int> cnt;

    for (int i = 0; i < 5; i++) {
        cnt[cards[i][0]]++;
    }

    if (cnt.size() != 2) {
        return false;
    }
    else {
        if (cnt.begin()->second == 1 || cnt.begin()->second == 4) {
            return true;
        }
        else {
            return false;
        }
    }
}

bool isFullHouse(vector<string> cards) {
    map<char, int> cnt;

    for (int i = 0; i < 5; i++) {
        cnt[cards[i][0]]++;
    }

    if (cnt.size() != 2) {
        return false;
    }
    else {
        if (cnt.begin()->second == 2 || cnt.begin()->second == 3) {
            return true;
        }
        else {
            return false;
        }
    }
}

bool isFlush(vector<string> cards) {
    set<char> suits;

    for (int i = 0; i < 5; i++) {
        suits.insert(cards[i][1]);
    }

    if (suits.size() == 1) {
        return true;
    }
    else {
        return false;
    }
}

bool isStraight(vector<string> cards) {
    set<int> values;

    for (int i = 0; i < 5; i++) {
        values.insert(getCardValue(cards[i][0]));
    }

    if (values.size() != 5) {
        return false;
    }
    else {
        int min = *values.begin();
        int max = *values.rbegin();

        if (max - min == 4) {
            return true;
        }
        else if (values.contains(14) && values.contains(2) && values.contains(3) && values.contains(4) && values.contains(5)) {
            return true;
        }
        else {
            return false;
        }
    }
}

bool isThreeOfAKind(vector<string> cards) {
    map<char, int> cnt;

    for (int i = 0; i < 5; i++) {
        cnt[cards[i][0]]++;
    }

    if (cnt.size() > 3) {
        return false;
    }
    else {
        for (const auto& pair : cnt) {
            if (pair.second == 3) {
                return true;
            }
        }

        return false;
    }
}

bool isTwoPairs(vector<string> cards) {
    map<char, int> cnt;

    for (int i = 0; i < 5; i++) {
        cnt[cards[i][0]]++;
    }

    if (cnt.size() != 3) {
        return false;
    }
    else {
        int count = 0;

        for (const auto& pair : cnt) {
            if (pair.second == 2) {
                count++;
            }
        }

        if (count == 2) {
            return true;
        }
        else {
            return false;
        }
    }
}

bool isPair(vector<string> cards) {
    map<char, int> cnt;

    for (int i = 0; i < 5; i++) {
        cnt[cards[i][0]]++;
    }

    for (const auto& pair : cnt) {
        if (pair.second == 2) {
            return true;
        }
    }

    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    for (int i = 0; i < T; i++) {
        vector<string> cards;

        for (int i = 0; i < 5; i++) {
            string card;
            cin >> card;

            cards.push_back(card);
        }

        if (isRoyalFlush(cards)) {
            cout << "royal flush" << "\n";
        }
        else if (isStraightFlush(cards)) {
            cout << "straight flush" << "\n";
        }
        else if (isFourOfAKind(cards)) {
            cout << "four of a kind" << "\n";
        }
        else if (isFullHouse(cards)) {
            cout << "full house" << "\n";
        }
        else if (isFlush(cards)) {
            cout << "flush" << "\n";
        }
        else if (isStraight(cards)) {
            cout << "straight" << "\n";
        }
        else if (isThreeOfAKind(cards)) {
            cout << "three of a kind" << "\n";
        }
        else if (isTwoPairs(cards)) {
            cout << "two pairs" << "\n";
        }
        else if (isPair(cards)) {
            cout << "pair" << "\n";
        }
        else {
            cout << "high card" << "\n";
        }
    }

    return 0;
}
