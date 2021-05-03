def solution(phone_book):
    phone_book.sort()
    for i, j in zip(phone_book, phone_book[1:]):
        if i == j[:len(i)]:
                return False
        """
        if p2.startswith(p1):
            return False
        """
    return True
