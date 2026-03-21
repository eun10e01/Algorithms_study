#include <string>
#include <vector>

using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
	int answer = -2;

	int size = queue1.size();
	long long sum = 0;

	long long sum1 = 0;
	long long sum2 = 0;

	for (int i = 0; i < size; i++) {
		sum1 += queue1[i];
		sum2 += queue2[i];
	}

	if (sum1 == sum2) {
		answer = 0;
		return answer;
	}
	else {
		sum = sum1 + sum2;
	}

	if (sum % 2 == 1) {
		answer = -1;
		return answer;
	}
	
	vector<int> temp = queue1;

	temp.insert(temp.end(), queue2.begin(), queue2.end());

	//투포인터 사용
	int count = 0;

	int start = 0;
	int end = size - 1;

	long long target = sum / 2;
	long long temp_sum = sum1;

	while (count < size * 4) {
		if (temp_sum == target) {
			answer = count;
			return answer;
		}
		else if (temp_sum > target) {
			temp_sum -= temp[start % (2 * size)];
			start++;
		}
		else {
			end++;
			temp_sum += temp[end % (2 * size)];
		}

		count++;
	}

	return -1;
}