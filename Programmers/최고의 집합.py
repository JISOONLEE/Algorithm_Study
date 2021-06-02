def solution(n, s):
    quo, rem = divmod(s, n)
    answer = [quo] * n
    if quo == 0:
        answer = [-1]
        return answer
    
    for i in range(rem):
        answer[i] += 1
    answer.sort()
    return answer
