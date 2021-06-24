#에라토스테네스의 체
check = [True] * 1000000

for i in range(2, len(check)//2+1):
    if check[i] == True:
        for j in range(i+i, len(check), i):
            check[j] = False

answer = []
while True:
    n = int(input())
    if n == 0:
        break
    if n % 2 == 1:
        answer.append("Goldbach's conjecture is wrong.")
    for i in range(3, len(check)):
        if check[i] == True:
            if check[n-i] == True:
                answer.append('%d = %d + %d' % (n, i, (n-i)))
                break
for i in range(len(answer)):
    print(answer[i])
