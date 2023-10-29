class Solution:
    def isInterleave(self, a: str, b: str, c: str) -> bool:
        return(f:=cache(lambda a,b,c:any(c[:1]==x[:1]and f(x[1:],y,c[1:])for x,y in((a,b),(b,a)))if(a and b)else(a or b or'')==c))(a,b,c)
