A, B, C = map(int, input("").split(" "))
money = 0
max = 0

if(A == B and B == C):
    money = 10000 + (A * 1000)
    print(money)
elif(A == B and B != C):
    money = 1000 + (A * 100)
    print(money)
elif(A != B and B == C):
    money = 1000 + (B * 100)
    print(money)
elif(A == C and B != C):
    money = 1000 + (A * 100)
    print(money)
else:
    dice = [A, B, C]
    
    for i in range(3):
        if(max <= dice[i]):
            max = dice[i]
    
    money = max * 100
    print(money)