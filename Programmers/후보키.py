from itertools import combinations

def solution(relation):
    answer = 0
    col=len(relation[0])
    row=len(relation)

    candi=[]
    for i in range(1, col+1):
        candi.extend(combinations(range(col),i))

    uniq=[]
    for c in candi:
        tmp=[tuple([item[i] for i in c]) for item in relation]
        if len(set(tmp))==row:
            uniq.append(c)

    answer=set(uniq)

    for i in range(len(uniq)):
        for j in range(i+1, len(uniq)):
            if len(uniq[i])== len(set(uniq[i])& set(uniq[j])):
                answer.discard(uniq[j])

    return len(answer)
