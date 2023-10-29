class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorderDic = {val:i for i, val in enumerate(inorder)}

        pos = len(postorder)-1
        def buildTree(lp, rp):
            nonlocal pos
            if pos < 0 or lp > rp:
                return None
            root = TreeNode(postorder[pos])
            pos -= 1
            i = inorderDic[root.val]
            root.right = buildTree(i+1, rp)                    
            root.left = buildTree(lp, i-1)
            return root

        return buildTree(0, pos)