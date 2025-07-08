N, K = map(int, input().split(" "))
temperature = input().split(" ")

sum = []

count = 0
max = -1000000

for i in range(N - K + 1):
    sum.append(0)
    for j in range(K):
        sum[i] += int(temperature[j + count]) # j + count로 하면 다음 번에는 temperature[1]부터 더할 수 있음
    count += 1

for i in range(len(sum)):
    if(sum[i] > max):
        max = sum[i]

print(max)
# 런타임 에러가 남