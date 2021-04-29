from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    for i in course:
        combs = []
        for order in orders:
            for co in combinations(order, i):
                co = ''.join(sorted(co))
                combs.append(co)
        candidate = Counter(combs).most_common()
        for menu, cnt in candidate:
            if cnt > 1 and cnt == candidate[0][1]:
                answer.append(menu)
    answer.sort()
    return answer
