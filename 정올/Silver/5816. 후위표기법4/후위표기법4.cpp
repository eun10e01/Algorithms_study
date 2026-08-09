#include <iostream>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    vector<int> value(26);
    string notation;
    stack<int> st;

    for (int i = 0; i < 26; i++) {
        cin >> value[i];
    }

    cin >> notation;

    for (char c : notation) {
        if (c >= 'A' && c <= 'Z') {
            st.push(value[c - 'A']);
        }
        else {
            int right = st.top();
            st.pop();
            int left = st.top();
            st.pop();

            int result;

            if (c == '+') {
                result = left + right;
            }
            else if (c == '-') {
                result = left - right;
            }
            else if (c == '*') {
                result = left * right;
            }
            else {
                if (right == 0) {
                    cout << "ZeroDivisionError";
                    return 0;
                }

                result = left / right;
            }

            st.push(result);
        }
    }

    cout << st.top();

    return 0;
}
