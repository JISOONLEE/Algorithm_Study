#bfs
from collections import deque
n, m= map(int, input().split())
graph = [ list(map(int, input())) for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs():
    visited = [False] * (n + 1)
    queue = deque()
    queue.append((0, 0))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and nx < n and ny >= 0 and ny <m:
                if graph[nx][ny] == 1:
                    graph[nx][ny] = graph[x][y]+1
                    queue.append((nx, ny))

    return graph[n-1][m-1]

print(bfs())
