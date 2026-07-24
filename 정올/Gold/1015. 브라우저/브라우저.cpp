#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	stack<string> forward_stack;
	stack<string> backward_stack;

	string now_page = "http://www.acm.org/";

	while (true) {
		string command, URL;
		cin >> command;

		if (command == "QUIT") {
			break;
		}

		if (command == "BACK") {
			if (backward_stack.empty()) {
				cout << "Ignored" << "\n";
			}
			else {
				forward_stack.push(now_page);
				now_page = backward_stack.top();
				backward_stack.pop();

				cout << now_page << "\n";
			}
		}
		else if (command == "FORWARD") {
			if (forward_stack.empty()) {
				cout << "Ignored" << "\n";
			}
			else {
				backward_stack.push(now_page);
				now_page = forward_stack.top();
				forward_stack.pop();

				cout << now_page << "\n";
			}
		}
		else if (command == "VISIT") {
			cin >> URL;

			backward_stack.push(now_page);
			now_page = URL;
			
			while (!forward_stack.empty()) {
				forward_stack.pop();
			}

			cout << now_page << "\n";
		}
	}
	
	return 0;
}
