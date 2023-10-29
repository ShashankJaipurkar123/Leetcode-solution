class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getNumericValue(firstWord) + getNumericValue(secondWord) == getNumericValue(targetWord);
    }

    public int getNumericValue(String str){
        int sum = 0;
        for(char c : str.toCharArray())
            sum = sum * 10 + (c - 'a'); 
        return sum;
    }
}