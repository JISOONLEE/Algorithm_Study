def dfs(computers, v, visited):
    visited[v] = True
    for i in range(len(computers[v])):
        if i != v and computers[v][i] == 1:
            if visited[i] == False:
                dfs(computers, i, visited)

def solution(n, computers):
    answer = 0
    visited = [False] * n
    for i in range(n):
        if visited[i] == False:
            dfs(computers, i, visited)
            answer += 1
    return answer
