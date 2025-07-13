number = []
check = []
flag = 0

for i in range(10):
    n = int(input())
    number.append(n % 42)

for i in range(10):
    if(len(check) == 0): # 처음 수는 그냥 추가
        check.append(number[i])
    else: # 그 다음 수부터는 check 리스트 안에 있는 수들과 비교한 뒤 추가
        for j in range(len(check)):
            if(number[i] == check[j]):
                flag = -1
        if(flag != -1):
            check.append(number[i])
        flag = 0

print(len(check))