#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int Q;
    cin >> Q;

    stack<string> books;

    for (int i = 0; i < Q; i++) {
        string S;
        cin >> S;

        if (S == "READ") {
            cout << books.top() << '\n';
            books.pop();
        }
        else {
            books.push(S);
        }
    }

    return 0;
}
