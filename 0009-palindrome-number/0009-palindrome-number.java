class Solution {
    public boolean isPalindrome(int x) {
        
        int reverse = 0;
        int temp = x;
        while(temp> 0){
            
            int lastdigit = temp %10;
            reverse = reverse *10 + lastdigit;
            temp = temp/10;

        }
        
        if(reverse == x){
            return true;
        }
        
        else{
            return false;
        }
        
    }
}