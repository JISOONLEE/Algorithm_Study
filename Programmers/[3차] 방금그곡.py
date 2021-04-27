def sharp(string):
    string = string.replace('C#', 'c')
    string = string.replace('D#', 'd')
    string = string.replace('F#', 'f')
    string = string.replace('G#', 'g')
    string = string.replace('A#', 'a')
    return string

def sub_time(start, finish):
    start = start.split(':')
    finish = finish.split(':')

    return (int(finish[0])*60+int(finish[1]))-(int(start[0])*60+int(start[1]))

def solution(m, musicinfos):
    answer=''
    musiclist = []

    m = sharp(m)
    for musicinfo in musicinfos:
        music = musicinfo.split(',')
        music[3] = sharp(music[3])
        sub = sub_time(music[0], music[1])
        if sub > len(music[3]):
            a, b = divmod(sub, len(music[3]))
            music[3] = music[3]*a + music[3][:b]
        elif sub < len(music[3]):
            music[3] = music[3][:sub]
        if m in music[3]:
            musiclist.append([music[2], sub])

    if len(musiclist) == 0:
        return "(None)"
    else:
        musiclist.sort(key = lambda x:x[1], reverse = True)
        print(musiclist)
        return musiclist[0][0]
