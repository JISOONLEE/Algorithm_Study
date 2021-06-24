import math
from itertools import combinations

answer = []
t = int(input())

for _ in range(t):
    total = 0
    arr = list(map(int, input().split()))
    for n, m in combinations(arr[1:], 2):
        total += int(math.gcd(n, m))
    answer.append(total)

for i in answer:
    print(i)
