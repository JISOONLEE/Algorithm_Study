def numeral_system(number, base):
    NOTATION = '0123456789ABCDEF'
    q, r = divmod(number, base)
    n = NOTATION[r]
    return numeral_system(q, base) + n if q else n

def solution(n, t, m, p):
    answer = ''
    result = ''
    for i in range(t*m):
        result += numeral_system(i, n)

    for i in range(p-1, t*m, m):
        answer += result[i]
    return answer
