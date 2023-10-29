class Solution {
    public int countGoodSubstrings(String s) {
        
        int start = 0;
        int end = 0;
        int ans = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(end < s.length()) {

            if(!map.containsKey(s.charAt(end))) {

                map.put((s.charAt(end)), 1);
                count++;
            }

            else {

                map.put(s.charAt(end), map.get(s.charAt(end)) + 1);

                if(map.get(s.charAt(end)) == 1) {
                    count++;
                }
            }

            if(end - start + 1 < 3) {
                end++;
            }

            else {
                if(count == 3) {
                    ans++;
                }

                if(map.containsKey(s.charAt(start))) {

                    map.put((s.charAt(start)), map.get(s.charAt(start)) - 1);

                    if(map.get(s.charAt(start)) == 0) {
                        count--;
                    }
                }
                
                start++;
                end++;
            }
        }
        return ans;
    }
}