#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void DFS(int idx, vector<vector<int>>& users, vector<int>& emoticons);

vector<int> discount;
vector<int> selected;

int max_subscribe;
int max_sales;

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
	vector<int> answer;

	discount = { 10, 20, 30, 40 };
	max_subscribe = 0;
	max_sales = 0;

	DFS(0, users, emoticons);

	answer.push_back(max_subscribe);
	answer.push_back(max_sales);

	return answer;
}

void DFS(int idx, vector<vector<int>>& users, vector<int>& emoticons) {
	if (idx == emoticons.size()) {
		int subscribe = 0;
		int sales = 0;

		for (auto& user : users) {
			int user_discount = user[0];
			int limit_price = user[1];

			int total = 0;

			for (int i = 0; i < emoticons.size(); i++) {
				if (selected[i] >= user_discount) {
					total += emoticons[i] * (100 - selected[i]) / 100;
				}
			}

			if (total >= limit_price) {
				subscribe++;
			}
			else {
				sales += total;
			}
		}

		if (subscribe > max_subscribe) {
			max_subscribe = subscribe;
			max_sales = sales;
		}
		else if (subscribe == max_subscribe) {
			max_sales = max(max_sales, sales);
		}

		return;
	}

	for (int d : discount) {
		selected.push_back(d);

		DFS(idx + 1, users, emoticons);
		selected.pop_back();
	}
}