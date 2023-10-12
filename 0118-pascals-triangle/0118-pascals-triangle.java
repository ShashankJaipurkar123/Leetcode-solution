class Solution {
   public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> pascal = new ArrayList<>();
       for (int i = 1; i <= numRows; i++) {
           if (i == 1) {
               List<Integer> first = new ArrayList<>();
               first.add(1);
               pascal.add(first);
           } else {
               List<Integer> prev = pascal.get(i - 2);
               List<Integer> nth = new ArrayList<>();
               for (int j = 0; j < i; j++) {
                   if (j == 0 || j == prev.size()) {
                       nth.add(1);
                   } else {
                       int sum = prev.get(j - 1) + prev.get(j);
                       nth.add(sum);
                   }
               }
               pascal.add(nth);
           }
       }
       return pascal;
   }
}