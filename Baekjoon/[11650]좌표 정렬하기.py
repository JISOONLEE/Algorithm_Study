n = int(input())
answer = []
for _ in range(n):
      x, y = map(int, input().split())
      answer.append([x, y])
answer.sort(key=lambda x:[x[0], x[1]])
for i in range(n):
      print(answer[i][0], answer[i][1])
