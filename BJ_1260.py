from collections import deque
n, m, v = map(int, input().split())
graph = [ [] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()

def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=' ')
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

def bfs(graph, v, visited):
    visited = [False] * (n + 1)
    queue = deque([v])
    visited[v] = True
    while queue:
        nv = queue.popleft()
        print(nv, end=' ')
        for i in graph[nv]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

dfs_visited = [False] * (n + 1)
bfs_visited = [False] * (n + 1)
dfs(graph, v, dfs_visited)
print()
bfs(graph, v, bfs_visited)