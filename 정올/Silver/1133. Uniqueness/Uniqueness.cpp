#include <iostream>
#include <unordered_map>
#include <vector>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    unordered_map<string, vector<int>> pos;
    vector<string> order;

    for (int i = 1; i <= N; i++) {
        string s;
        cin >> s;

        if (pos.find(s) == pos.end()) {
            order.push_back(s);
        }
        pos[s].push_back(i);
    }

    bool unique = true;

    for (const string &s : order) {
        if (pos[s].size() >= 2) {
            unique = false;
            cout << s;

            for (int idx : pos[s]) {
                cout << " " << idx;
            }
            cout << '\n';
        }
    }

    if (unique) {
        cout << "unique";
    }

    return 0;
}
