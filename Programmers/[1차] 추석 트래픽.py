def traffic(start, times):
    end = start + 1000 -1
    result = 0
    for time in times:
        if time[0] <= start and start <= time[1]:
            result += 1
        elif start <= time[0]and time[0] <= end:
            result += 1
        elif start <= time[0] and time[1] <= end:
            result += 1
    return result 

def solution(lines):
    time_list = []
    for line in lines:
        date, time, proc_time = line.split()
        time = time.split(':')
        end = (int(time[0]) * 3600 * 1000 + int(time[1]) * 60 * 1000 + float(time[2]) * 1000)
        start = end - float(proc_time[:-1]) *1000 + 1
        time_list.append([int(start), int(end)])

    time_list = sorted(time_list, key = lambda x:x[1])
    result = 0
    for time in time_list:
        result = max(traffic(time[0], time_list), result)
        result = max(traffic(time[1], time_list), result)
    return result
