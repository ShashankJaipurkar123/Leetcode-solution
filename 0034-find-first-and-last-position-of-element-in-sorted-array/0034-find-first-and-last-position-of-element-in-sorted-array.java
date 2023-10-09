class Solution {
    public int[] searchRange(int[] nums, int target) {
        double lt = target - 0.5;
        double rt = target + 0.5;
        
        int left = binarySearch(nums, lt);
        int right = binarySearch(nums, rt);
        
        if(left >= nums.length || nums[left] != target){
            return new int[]{-1, -1};
        }
        
        if(nums[right] == target){
            return new int[]{left, right};
        }
        return new int[]{left, right - 1};
    }
    
    public int binarySearch(int[] nums, double target){
        int left = 0;
        int right = nums.length - 1;
        
        
        while(left < right){
            int mid = (right - left) / 2 + left;
            
            if(nums[mid] > target){
                right--;
            }else{
                left++;
            }
        }
        return left;   
    }
}