#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool check_leap_year(int year) {
	if (year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0))) {
		return true;
	}

	return false;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int y, m, d;

	while (true) {
		cin >> y >> m >> d;

		bool isLeapYear = check_leap_year(y);

		if (y < 2000 || y > 2010) {
			cout << "INPUT ERROR!" << "\n";
		}
		else if (m < 1 || m > 12) {
			cout << "INPUT ERROR!" << "\n";
		}
		else if (m == 2) {
			if (isLeapYear) {
				if (d < 1 || d > 29) {
					cout << "INPUT ERROR!" << "\n";
				}
				else {
					break;
				}
			}
			else {
				if (d < 1 || d > 28) {
					cout << "INPUT ERROR!" << "\n";
				}
				else {
					break;
				}
			}
		}
		else if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
			if (d < 1 || d > 31) {
				cout << "INPUT ERROR!" << "\n";
			}
			else {
				break;
			}
		}
		else {
			if (d < 1 || d > 30) {
				cout << "INPUT ERROR!" << "\n";
			}
			else {
				break;
			}
		}
	}

	int year_cnt = 2000;
	int day_cnt = 0;

	for (int i = 0; i < y - 2000; i++) {
		if (check_leap_year(year_cnt)) {
			day_cnt += 366;
		}
		else {
			day_cnt += 365;
		}

		year_cnt++;
	}

	for (int i = 1; i <= m - 1; i++) {
		if (i == 2) {
			if (check_leap_year(y)) {
				day_cnt += 29;
			}
			else {
				day_cnt += 28;
			}
		}
		else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
			day_cnt += 31;
		}
		else {
			day_cnt += 30;
		}
	}

	int idx = 6;
	vector<string> days = { "sun", "mon", "tue", "wed", "thu", "fri", "sat" };

	idx += day_cnt % 7;
	if (idx > 6) {
		idx -= 7;
	}

	cout << y << ". " << m << "\n";
	
	for (int i = 0; i < 7; i++) {
		cout << days[i] << " ";
	}
	cout << "\n";

	int now_day = 0;

	for (int i = idx; i > 0; i--) {
		cout << "    ";
		now_day++;
	}

	int count = 0;

	if (m == 2) {
		if (check_leap_year(y)) {
			count = 29;
		}
		else {
			count = 28;
		}
	}
	else if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
		count = 31;
	}
	else {
		count = 30;
	}

	int save_day;

	for (int i = 1; i <= count; i++) {
		if (now_day == 7) {
			now_day = 0;
			cout << "\n";
		}

		if (i == d) {
			save_day = now_day;
		}

		if (i < 10) {
			cout << "  " << i << " ";
		}
		else {
			cout << " " << i << " ";
		}

		now_day++;
	}
	cout << "\n";

	switch (save_day) {
	case 0:
		cout << "Sunday";
		break;
	case 1:
		cout << "Monday";
		break;
	case 2:
		cout << "Tuesday";
		break;
	case 3:
		cout << "Wednesday";
		break;
	case 4:
		cout << "Thursday";
		break;
	case 5:
		cout << "Friday";
		break;
	case 6:
		cout << "Saturday";
	}

	return 0;
}
