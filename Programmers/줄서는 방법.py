"""
효율성 통과x
from itertools import permutations

def solution(n, k):
    peo = [i for i in range(1, n+1)]
    for idx, value in enumerate(permutations(peo, n)):
        if idx == (k-1):
            return value
"""

import math

def solution(n, k):
    nums = [i for i in range(1, n+1)]
    answer = []
    while n > 0:
        temp = math.factorial(n-1)
        index, k = (k-1)//temp, k%temp
        answer.append(nums.pop(index))
        n -= 1
    return answer
