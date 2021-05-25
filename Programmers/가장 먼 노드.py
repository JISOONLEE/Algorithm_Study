from collections import deque

def bfs(graph, start, visited, cnt):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                cnt[i] = 1 + cnt[v]

def solution(n, edge):
    graph = [[] for _ in range(n+1)]
    for i in edge:
        graph[i[0]].append(i[1])
        graph[i[1]].append(i[0])

    visited = [False] * (n+1)

    cnt = [0] * (n+1)

    bfs(graph, 1, visited, cnt)

    m = max(cnt)
    return cnt.count(m)
