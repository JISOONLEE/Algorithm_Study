def solution(n, times):
    left, right = 1, max(times) * n
    while left < right:
        mid = (left + right) // 2
        if sum([mid // x for x in times]) < n: 
            left = mid + 1
        else: 
            right = mid
    return left
