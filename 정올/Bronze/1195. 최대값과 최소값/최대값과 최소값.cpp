#include <iostream>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int num[10];
    int n;

    for (int i = 0; i < 10; i++) {
        cin >> num[i];
    }

    cin >> n;

    int largest_min = 0;
    int smaller_max = 1001;

    for (int i = 0; i < 10; i++) {
        int temp = num[i];

        if (temp < n && temp > largest_min) {
            largest_min = temp;
        }

        if (temp > n && temp < smaller_max) {
            smaller_max = temp;
        }
    }

    if (largest_min == 0) {
        cout << n << "\n";
    }
    else {
        cout << largest_min << "\n";
    }

    if (smaller_max == 1001) {
        cout << n << "\n";
    }
    else {
        cout << smaller_max << "\n";
    }

    return 0;
}
