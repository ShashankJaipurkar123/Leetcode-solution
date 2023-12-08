class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.substring(1, sb.length()-1);
    }
    
    private void helper(TreeNode node, StringBuilder sb){
        if(node == null){ return; }
        
        sb.append("(");
        sb.append(String.valueOf(node.val));
        
        if(node.left == null && node.right != null){ sb.append("()"); }
        
        helper(node.left, sb);
        helper(node.right, sb);
        sb.append(")");
    }
}