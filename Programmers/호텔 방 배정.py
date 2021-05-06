"""
# 효율성 0%
def solution(k, room_number):
    answer = []
    visited = [0] * k
    for i in room_number:
        if visited[i-1] == 0:
            visited[i-1] = 1
            answer.append(i)
        else:
            idx = visited[i:].index(0)
            visited[idx+i] = 1
            answer.append(idx+i+1)
    return answer
"""
