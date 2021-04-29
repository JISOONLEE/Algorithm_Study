from itertools import combinations 
from bisect import bisect_left, bisect_right

def solution(info, query):
    answer = []
    dic = {}
    for i in info:
        info_li = i.split()
        info_key = info_li[:-1]
        info_score = int(info_li[-1])
        
        for i in range(5):
            for comb in combinations(info_key, i):
                key = ''.join(comb)
                if key in dic.keys():
                    dic[key].append(info_score)
                else:
                    dic[key] = [info_score]
    for key in dic.keys():
        dic[key].sort()
                    
    for q in query:
        qry = [i for i in q.split() if i != 'and' and i!='-']
        qry_info = ''.join(qry[:-1])
        qry_score = int(qry[-1])
        cnt = 0
        if qry_info in dic:
            scores = dic[qry_info]
            if len(scores) == 1 and scores[0] > qry_score:
                cnt = 1
            else:
                cnt = len(scores) - bisect_left(scores, qry_score)
            
        answer.append(cnt)
    return answer
