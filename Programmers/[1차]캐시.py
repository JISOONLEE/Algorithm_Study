def solution(cacheSize, cities):
    answer = 0
    cache_list = ['']*cacheSize
    
    for city in cities:
        city = city.lower()
        if city in cache_list:
            answer += 1
            cache_list.remove(city)
            cache_list.append(city)
        else:
            answer += 5
            cache_list.append(city)
            cache_list.pop(0)
    return answer
