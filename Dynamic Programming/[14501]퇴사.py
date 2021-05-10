n = int(input())

graph = [ list(map(int, input().split())) for _ in range(n)]
max_value = 0
dp = [0]*(n+1)

for i in range(n-1, -1, -1):
    time = graph[i][0] + i
    if time <= n:
        dp[i] = max(graph[i][1]+dp[time], max_value)
        max_value = dp[i]
    else:
        dp[i] = max_value

print(max_value)
