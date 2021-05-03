import math
def solution(arr):
    answer = arr[0]*arr[1] // math.gcd(arr[0], arr[1])

    for i in arr[2:]:
        answer = answer*i // math.gcd(answer, i)

    return answer
