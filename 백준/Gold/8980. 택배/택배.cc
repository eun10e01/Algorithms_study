#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <deque>

using namespace std;

int main() {
	int N, C, M;
	cin >> N >> C >> M;

	priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, greater<tuple<int, int, int>>> boxes;
	deque<pair<int, int>> truck;

	int start, end, cnt;

	//택배들을 보내는 마을(start) 기준으로 정렬
	for (int i = 0; i < M; i++) {
		cin >> start >> end >> cnt;

		boxes.push(make_tuple(start, end, cnt));
	}

	int ans = 0;

	//마을 수만큼 반복
	for (int i = 1; i <= N; i++) {
		//택배 배송하기
		while (true) {
			//1번 마을에는 배송할 택배가 없음.
			if (i == 1 || truck.empty()) {
				break;
			}

			pair<int, int> truck_temp = truck.front();

			//배송지가 현재 마을이 아니면 break
			if (get<0>(truck_temp) != i) {
				break;
			}

			truck.pop_front();
			C += get<1>(truck_temp);
			ans += get<1>(truck_temp); //배송완료
		}

		//택배를 싣기
		while (true) {
			//택배가 없으면 break
			if (boxes.empty()) {
				break;
			}

			tuple<int, int, int> boxes_temp = boxes.top();

			//택배를 보내는 마을이 현재 마을이 아니라면 break;
			if (get<0>(boxes_temp) != i) {
				break;
			}

			boxes.pop();

			//트럭이 현재 비어있다면 용량만큼의 택배를 그냥 넣기
			if (truck.empty()) {
				if (get<2>(boxes_temp) < C) {
					truck.push_back(make_pair(get<1>(boxes_temp), get<2>(boxes_temp)));
					C -= get<2>(boxes_temp);
				}
				else {
					if (C != 0) {
						truck.push_back(make_pair(get<1>(boxes_temp), C));
						C = 0;
					}
				}
			}
			else { //비어있지 않다면 택배를 넣고 정렬하기
				if (get<2>(boxes_temp) < C) {
					truck.push_back(make_pair(get<1>(boxes_temp), get<2>(boxes_temp)));
					C -= get<2>(boxes_temp);

					sort(truck.begin(), truck.end());
				}
				else {
					pair<int, int> temp = truck.back();

					if (C == 0) {
						//만약 택배에 빈자리가 없을 경우 >> (가장 마지막의 택배 배송지 > 현재 택배 배송지)라면 >> 가장 마지막의 택배를 버리고 현재 택배를 트럭에 넣는다.
						if (get<1>(boxes_temp) < get<0>(temp)) {
							truck.pop_back();
							C += get<1>(temp);

							if (get<2>(boxes_temp) < C) {
								truck.push_back(make_pair(get<1>(boxes_temp), get<2>(boxes_temp)));
								C -= get<2>(boxes_temp);
							}
							else {
								truck.push_back(make_pair(get<1>(boxes_temp), C));
								C = 0;
							}

							sort(truck.begin(), truck.end());
						}
					}
					else {
						if (C + get<1>(temp) <= get<2>(boxes_temp)) {
							truck.pop_back();
							C += get<1>(temp);

							if (get<2>(boxes_temp) < C) {
								truck.push_back(make_pair(get<1>(boxes_temp), get<2>(boxes_temp)));
								C -= get<2>(boxes_temp);
							}
							else {
								truck.push_back(make_pair(get<1>(boxes_temp), C));
								C = 0;
							}

							sort(truck.begin(), truck.end());
						}
						else {
							if (get<2>(boxes_temp) < C) {
								truck.push_back(make_pair(get<1>(boxes_temp), get<2>(boxes_temp)));
								C -= get<2>(boxes_temp);
							}
							else {
								truck.push_back(make_pair(get<1>(boxes_temp), C));
								C = 0;
							}

							sort(truck.begin(), truck.end());
						}
					}
				}
			}
		}
	}

	cout << ans;
}