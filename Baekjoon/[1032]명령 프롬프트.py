n = int(input())
answer = list(input()) #한줄만 받고 비교
for i in range(n-1):
      answer2 = list(input())
      for j in range(len(answer)):
            if answer[j] !=answer2[j]:
                  answer[j] = '?'
print(''.join(answer))
