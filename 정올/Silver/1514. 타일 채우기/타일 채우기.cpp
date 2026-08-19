#include <iostream>

using namespace std;

int main() {
    long long W, H;
    cin >> W >> H;

    long long a = W;
    long long b = H;

    while (b != 0) {
        long long temp = a % b;
        a = b;
        b = temp;
    }

    //a = gcd(W, H)
    cout << (W / a) * (H / a);

    return 0;
}
