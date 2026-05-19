#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    string n;

    while (true) {
        cin >> n;

        if (n == "0") {
            break;
        }

        int sum = 0;

        string temp;

        for (int i = n.length() - 1; i >= 0; i--) {
            temp += n[i];
            sum += n[i] - '0';
        }

        cout << stoi(temp) << " " << sum << '\n';
    }

    return 0;
}
