# 간단한 swap 문제
N, M = map(int, input().split(" "))
ball = [] # 리스트 생성

for n in range(N):
    ball.append(n + 1)

for n in range(M):
    i, j = map(int, input().split(" "))

    # 공 교환
    temp = ball[i - 1]
    ball[i - 1] = ball[j - 1]
    ball[j - 1] = temp

for n in range(N):
    print(ball[n], end = ' ')