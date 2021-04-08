##
def dp(n, m, graph):
    for i in range(1, m):
        for j in range(n):
            if j == 0:
                graph[j][i] = graph[j][i]+max(graph[j][i-1], graph[j+1][i-1])
            elif j == n-1:
                graph[j][i] = graph[j][i] + max(graph[j-1][i-1], graph[j][i - 1])
            else:
                graph[j][i] = graph[j][i] + max(graph[j - 1][i - 1], graph[j][i - 1], graph[j+1][j-1])
    result = 0
    for i in range(n):
        result = max(result, graph[i][m - 1])
    return result


t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    array = list(map(int, input().split()))
    graph = []
    for i in range(n):
        graph.append(array[i*m:i*m+m])
    print(dp(n, m, graph))
