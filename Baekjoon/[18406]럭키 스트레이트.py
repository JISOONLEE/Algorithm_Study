n = str(input())
n = list(n)
cnt = len(n)//2
l_val, r_val = 0, 0
lef= n[0:cnt]
rig = n[cnt:]

for i in range(cnt):
    l_val += int(lef[i])
    r_val += int(rig[i])

if r_val == l_val:
    print('LUCKY')
else:
    print('READY')
