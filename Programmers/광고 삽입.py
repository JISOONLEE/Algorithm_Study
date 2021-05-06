def str_to_time(time):
    h, m, s = time.split(':')
    sec = int(h) * 3600 + int(m) * 60 + int(s)
    return sec

def time_to_str(time):
    h = str(time//3600).zfill(2)
    time = time%3600
    m = str(time//60).zfill(2)
    s = str(time%60).zfill(2)
    return h + ':' + m + ':' + s

def solution(play_time, adv_time, logs):
    answer = ''
    play_time = str_to_time(play_time)
    adv_time = str_to_time(adv_time)
    all_time = [0] * (play_time+1)
    for log in logs:
        start, end = log.split('-')
        start = str_to_time(start)
        end = str_to_time(end)
        all_time[start] += 1
        all_time[end] -= 1

    for i in range(1, play_time):
        all_time[i] = all_time[i] + all_time[i-1]

    for i in range(1, play_time):
        all_time[i] = all_time[i] + all_time[i-1]

    most_time = 0
    max_time = 0

    for i in range(adv_time-1, play_time):
        if i>= adv_time:
            if most_time < all_time[i] - all_time[i-adv_time]:
                most_time = all_time[i] - all_time[i-adv_time]
                max_time = i-adv_time+1
        else:
            if most_time < all_time[i]:
                most_time = all_time[i]
                max_time = i - adv_time + 1

    return time_to_str(max_time)
