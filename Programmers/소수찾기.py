from itertools import permutations
def pn(num):
    if num ==0 or num == 1:
        return False
    for i in range(2, num):
        if num%i == 0:
            return False
    return True


def solution(numbers):
    answer = 0
    number = []
    set_num = []
    for i in numbers:
        number.append(i)
    for i in range(1, len(numbers)+1):
        for j in permutations(number, i):
            set_num.append(int(''.join(j)))
    for i in set(set_num):
        if pn(i):
            answer+=1
    return answer
