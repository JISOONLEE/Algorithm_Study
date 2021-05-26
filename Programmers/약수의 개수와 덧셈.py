def check(n):
    cnt = 0
    for i in range(1, n+1):
        if n % i == 0:
            cnt += 1
    if cnt % 2 == 0:
        return True
    else:
        return False

def solution(left, right):
    answer = 0
    for n in range(left, right+1):
        if check(n):
            answer += n
        else:
            answer -= n
    return answer
