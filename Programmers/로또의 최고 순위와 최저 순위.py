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
