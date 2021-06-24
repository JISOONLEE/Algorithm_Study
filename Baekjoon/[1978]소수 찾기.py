n = int(input())
numbers = map(int, input().split())
answer = 0
for number in numbers:
    check = 0
    if number > 1:
        for i in range(2, number//2+1):
            if number%i == 0:
                check += 1
        if check == 0:
            answer += 1
print(answer)
