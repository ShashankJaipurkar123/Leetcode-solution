class Solution {
    public int sumNumbers(TreeNode root) {
      if(root==null) return 0;
        return helper(root,0);
    }
     private int helper(TreeNode root, int sumvalue){
      if(root==null) return 0;
      sumvalue=sumvalue*10+root.val;
      if(root.left==null && root.right==null) return sumvalue;
      return helper(root.left,sumvalue)+helper(root.right,sumvalue);
     }
}