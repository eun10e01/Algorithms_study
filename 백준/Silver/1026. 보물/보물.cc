#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	long S = 0;

	cin >> N;

	vector<int> A(N);
	vector<int> B(N);

	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}

	sort(A.begin(), A.end());

	for (int i = 0; i < N; i++) {
		cin >> B[i];
	}

	sort(B.begin(), B.end(), greater<int>());

	for (int i = 0; i < N; i++) {
		S += (A[i] * B[i]);
	}

	cout << S;

	return 0;
}