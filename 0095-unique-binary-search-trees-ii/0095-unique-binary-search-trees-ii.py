class Solution(object):
    def generateTrees(self, n):
        
        def gen(l, r):
            res = []            
            for i in range(l, r+1):
                lnodes = gen(l, i-1)
                rnodes = gen(i+1, r)
                for lnode in lnodes or [None]:
                    for rnode in rnodes or [None]:
                        res.append(TreeNode(i, lnode, rnode))
            return res
        
        return gen(1, n)