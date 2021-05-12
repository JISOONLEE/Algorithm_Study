from itertools import permutations

n = int(input())
m = list(map(int, input().split()))

"""
result = []
for i in range(n+1):
    for j in permutations(m, i):
        result.append(sum(j))
result.sort()
result = list(set(result))

answer = 0
for i in range(1, len(result)):
    if result[i-1]+1 != result[i]:
        answer = result[i-1] + 1
        break
print(answer)
"""

#그리디로 구현
m.sort()

target = 1
for x in m:
    if target < x :
        break
    target += x

print(target)
