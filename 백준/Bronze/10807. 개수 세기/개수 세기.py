n = int(input(""))
numbers = list(map(int, input("").split(" ")))
t = int(input(""))
ans = 0

for i in range(n):
    if(numbers[i] == t):
        ans = ans + 1

print(ans)