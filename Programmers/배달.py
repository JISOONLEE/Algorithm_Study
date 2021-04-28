# 다익스트라로 풀었지만 dfs도 가능
import heapq
def dijkstra(start, graph, distance):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] <dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance

def solution(N, road, K):
    answer = 0
    distance = [1e9] * (N+1)
    graph = [[] for i in range(N+1)]
    for i in road:
        graph[i[0]].append((i[1], i[2]))
        graph[i[1]].append((i[0], i[2]))
    distance = dijkstra(1, graph, distance)
    distance = distance[1:]
    print(distance, K)
    for dis in distance:
        if dis <= K:
            print(dis)
            answer += 1
    return answer
