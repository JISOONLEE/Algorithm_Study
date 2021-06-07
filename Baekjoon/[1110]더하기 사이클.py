n = str(input())
m = n
cnt = 0
while 1:
      if len(m) == 1:
            m = '0' + m
      answer = m[-1] + str(int(m[0]) + int(m[1]))[-1]
      m = answer
      cnt += 1
      if int(m) == int(n):
          print(cnt)
          break
