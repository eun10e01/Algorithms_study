#include <iostream>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	string ah, doctor;

	cin >> ah >> doctor;

	if (ah.size() >= doctor.size()) {
		cout << "go";
	}
	else {
		cout << "no";
	}

	return 0;
}