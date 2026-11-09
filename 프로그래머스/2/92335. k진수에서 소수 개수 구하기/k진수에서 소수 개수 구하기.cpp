
#include <string>
#include <algorithm>
using namespace std;

bool isPrime(long long num) {
    if (num < 2)
        return false;

    for (long long i = 2; i * i <= num; i++) {
        if (num % i == 0)
            return false;
    }

    return true;
}

int solution(int n, int k) {
    int answer = 0;
    string str = "";

    while (n > 0) {
        str += to_string(n % k);
        n /= k;
    }

    reverse(str.begin(), str.end());

    string temp = "";

    for (int i = 0; i < str.size(); i++) {
        if (str[i] == '0') {
            if (!temp.empty()) {
                long long num = stoll(temp);

                if (isPrime(num))
                    answer++;

                temp = "";
            }
        }
        else {
            temp += str[i];
        }
    }

    if (!temp.empty()) {
        long long num = stoll(temp);

        if (isPrime(num))
            answer++;
    }

    return answer;
}