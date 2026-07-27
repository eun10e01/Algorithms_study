#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <set>
#include <map>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    string num1, num2;
    cin >> num1 >> num2;

    int carry = 0;
    int carry_cnt = 0;

    int i = num1.length() - 1;
    int j = num2.length() - 1;

    while (i >= 0 || j >= 0 || carry > 0) {
        int sum = carry;

        if (i >= 0) {
            sum += num1[i] - '0';
            i--;
        }

        if (j >= 0) {
            sum += num2[j] - '0';
            j--;
        }

        if (sum >= 10) {
            carry = 1;
            carry_cnt++;
        }
        else {
            carry = 0;
        }
    }

    if (carry_cnt == 0) {
        cout << "No carry operation.";
    }
    else if (carry_cnt == 1) {
        cout << "1 carry operation.";
    }
    else {
        cout << carry_cnt << " carry operations.";
    }

    return 0;
}
