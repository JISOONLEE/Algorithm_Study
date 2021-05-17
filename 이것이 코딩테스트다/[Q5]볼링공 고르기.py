n, m = map(int, input().split())
k = list(map(int, input().split()))
answer = 0
for i in range(len(k)):
    first = k[i]
    temp = k[i+1:]
    answer += (len(temp)-temp.count(first))
print(answer)
