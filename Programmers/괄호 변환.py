def balance(p):
    count = 0
    for i, value in enumerate(p):
        if value == "(":
            count += 1
        else:
            count -= 1
        if count == 0:
            return i       
        
def is_right(p):
    stack = []
    for i in p:
        if i == "(":
            stack.append(i)
        else:
            if len(stack) == 0:
                return False
            stack.pop()
    if len(stack) == 0: return True
    else:   return False
        
def solution(p):
    if p == '' or is_right(p):
        return p
    u, v = p[:balance(p)+1], p[balance(p)+1:]
    print('u='+u)
    print('v='+v)
    
    if is_right(u):
        string = solution(v)
        return u+string
    else:
        string = '('
        string += solution(v)
        string += ')'
        u = list(u[1:-1])
        for i in range(len(u)):
            if u[i] == '(':
                u[i] = ')'
            else:
                u[i] = '('
        string += ''.join(u)
    
        return string
