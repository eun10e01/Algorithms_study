#include <iostream>
#include <sstream>
#include <map>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
	  cin.tie(NULL);

    string line;

    while (true) {
        getline(cin, line);

        if (line == "END") {
            break;
        }

        map<string, int> wordCount;

        stringstream ss(line);
        string word;

        while (ss >> word) {
            wordCount[word]++;
        }

        for (auto it = wordCount.begin(); it != wordCount.end(); ++it) {
            cout << it->first << " : " << it->second << '\n';
        }
    }

    return 0;
}
