def solution(s):
    answer = len(s)
    for i in range(1, len(s)//2+1):
        count = 1
        result = ''
        temp = s[:i]
        for j in range(i, len(s), i):
            if temp == s[j:j+i]:
                count+=1
            else:
                if count != 1:
                    result = result + str(count) + temp
                    count = 1
                else:
                    result = result + temp
                temp = s[j:j+i]
        if count != 1:
            result = result + str(count)+temp
        else:
            result = result + temp
        answer = min(answer, len(result))

    return answer
