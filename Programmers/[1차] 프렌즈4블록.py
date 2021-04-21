# 2*2 블록 찾기
def seek(m, n, b_list, visited):
    for i in range(m-1):
        for j in range(n-1):
            if b_list[i][j] != '0' and b_list[i][j] == b_list[i+1][j] == b_list[i][j+1] == b_list[i+1][j+1]:
                visited[i][j], visited[i+1][j],visited[i][j+1], visited[i+1][j+1] = True, True, True, True
                # b_list에 값이 같다고 표기시 붙어있는 블록 체크 불가 따라서 visited에서 표기 
    return visited

# 2*2 블록 제거 후 빈공간 채우기
def block_remove(m, n, b_list, visited):
    count = 0
    for i in range(m):
        for j in range(n):
            if visited[i][j] == True:
                b_list[i][j] = '#'
                visited[i][j] = False

    b_list = list(map(list, zip(*b_list)))
    for i in b_list:
        if i.count('#') > 0:
            for _ in range(i.count('#')):
                i.remove('#')
                i.insert(0, '0')

    b_list = list(map(list, zip(*b_list)))
    return visited, b_list

# 지워진 블록 확인하기
def zero_count(b_list):
    count = 0
    for i in b_list:
        count += i.count('0')
    return count

def solution(m, n, board):
    b_list=[]
    for i in board:
        b_list.append([j for j in i])
    visited = [[False] * n for _ in range(m)]
    cnt = 0
    while True:
        visited = seek(m, n, b_list, visited)
        visited, b_list = block_remove(m, n, b_list, visited)
        count = zero_count(b_list)

        if cnt == count:
            return cnt
        else:
            cnt = count
