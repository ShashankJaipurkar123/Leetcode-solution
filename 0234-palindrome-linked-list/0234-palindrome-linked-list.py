class Solution:
    
    def isPalindrome(self, head):
        res = ''
        while head:
            res+= str(head.val)
            head = head.next
            
        return res == res[::-1]