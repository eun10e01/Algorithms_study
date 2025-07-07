N, M = map(int, input().split(" "))
ball = []

for n in range(N):
    ball.append(n + 1)

for n in range(M):
    i, j = map(int, input().split(" "))

    temp = ball[i - 1]
    ball[i - 1] = ball[j - 1]
    ball[j - 1] = temp

for n in range(N):
    print(ball[n], end = ' ')
