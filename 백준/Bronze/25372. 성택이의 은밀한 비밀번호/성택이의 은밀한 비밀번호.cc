#include <iostream>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	string temp;

	for (int i = 0; i < N; i++) {
		cin >> temp;

		if (temp.size() >= 6 && temp.size() <= 9) {
			cout << "yes" << endl;
		}
		else {
			cout << "no" << endl;
		}
	}

	return 0;
}