class Solution {
public:
     int solve(string t1,string t2){
        const int m = t1.size();
        const int n = t2.size();
        vector<vector<int>> dp(2,vector<int>(n+1,0));
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
            if(t1[i-1]==t2[j-1]){ dp[i&1][j] = 1 + dp[(i-1)&1][j-1];}
            else{dp[i&1][j] = max(dp[(i-1)&1][j], dp[i&1][j-1]);}
            }
        }
        return dp[m&1][n];
    }
    
    
    int minDistance(string word1, string word2) {
        int common = solve(word1,word2);
        return word1.size() + word2.size() - 2 * common;
    }
};