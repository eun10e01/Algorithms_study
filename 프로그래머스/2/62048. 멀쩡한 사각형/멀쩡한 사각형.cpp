#include <iostream>

using namespace std;

long long find_gcd(int x, int y) {
	if (y == 0) {
		return x;
	}

	return find_gcd(y, x % y);
}

long long solution(int w, int h) {
	long long answer = 1;

	long long gcd = find_gcd(w, h);
	answer = (long long)w * h - (w + h - gcd);

	return answer;
}