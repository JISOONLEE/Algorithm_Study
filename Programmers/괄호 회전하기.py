def is_right(s):
    stack = []
    for i in s:
        if i in ('[', '(', '{'):
            stack.append(i)
        else:
            if len(stack) == 0:
                return 0
            else:
                x = stack.pop()
                if i == ']' and x != '[': return 0
                elif i == ')' and x != '(': return 0
                elif i == '}' and x != '{': return 0
    if len(stack)!=0:
        return 0
    else:
        return 1

def solution(s):
    answer = 0
    for i in range(len(s)):
        answer += is_right(s[i:]+s[:i])
    return answer
