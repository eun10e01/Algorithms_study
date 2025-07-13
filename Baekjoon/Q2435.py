N, K = map(int, input().split())
temperature = list(map(int, input().split())) # split(" ")로 적으면 런타임 에러가 날 수 있음

sum = 0

max = -1000000000

for i in range(N - K + 1):
    sum = 0
    for j in range(K):
        sum += int(temperature[j + i]) # j + i로 하면 다음 번에는 temperature[1]부터 더할 수 있음

    if(sum > max):
        max = sum

print(max)