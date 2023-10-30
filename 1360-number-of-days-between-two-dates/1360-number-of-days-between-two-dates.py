from datetime import datetime
class Solution:
    def daysBetweenDates(self, date1: str, date2: str) -> int:
        x = datetime.strptime(date1, '%Y-%m-%d')
        y = datetime.strptime(date2, '%Y-%m-%d')
        return abs((y - x).days)