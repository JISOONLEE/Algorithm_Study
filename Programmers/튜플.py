def solution(s):
    answer = []
    s = s[2:-2].split("},{")
    s_list = sorted([i.split(',') for i in s], key=len)
    for sl in s_list:
        for i in sl:
            if int(i) not in answer:
                answer.append(int(i))
    return answer
