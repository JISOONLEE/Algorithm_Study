from itertools import permutations

def check(case, banned_id):
    for i in range(len(banned_id)):
        if len(banned_id[i]) != len(case[i]):
            return False
        else:
            for j in range(len(banned_id[i])):
                if banned_id[i][j] != '*' and banned_id[i][j] != case[i][j]:
                    return False
    return True

def solution(user_id, banned_id):
    answer = []
    cases = list(permutations(user_id, len(banned_id)))
    for case in cases:
        if check(case, banned_id):
            case = list(case)
            case.sort()
            if case not in answer:
                answer.append(case)
    return len(answer)
