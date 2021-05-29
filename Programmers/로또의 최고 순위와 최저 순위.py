"""
def solution(lottos, win_nums):
    ans_min = []
    for win_num in win_nums:
        if win_num in lottos:
            ans_min.append(win_num)
    ans_max = lottos.count(0) + len(ans_min)
    if len(ans_min) == 0:
        ans_min.append(0)
    if ans_max == 0:
        ans_max = 1
    answer = [7-ans_max, 7-len(ans_min)]
    return answer
"""
def solution(lottos, win_nums):
    rank = [1,2,3,4,5,6,6]
    min_num = len(set(win_nums) - set(lottos))
    max_num = min_num - lottos.count(0)
    return rank[max_num], rank[min_num]
