class Solution {
public:
    int numDistinct(string s, string t) {
        
        /*
        
        Recurrence Relation
        -------------------

        if(s[i] == t[j]){
            f(i,j) = f(i-1,j) + f(i-1, j-1)
        }
        else{
            f(i,j) = f(i-1,j)
        }

        Base Cases
        ----------

        if(i<0){
            return 0;
        }
        else if (j<0){
            return 1;
        }

        */

        int n = s.length();
        int m = t.length();
        long long longmax = 1000000000000000000;

        vector<vector<long long>> dp(n+1, vector<long long>(m+1, -1));

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(j == 0){
                    dp[i][j] = 1;
                }
                else if(i == 0){
                    dp[i][j] = 0;
                }
                else{
                    if(s[i-1] == t[j-1]){
                        dp[i][j] = (dp[i-1][j]%longmax + dp[i-1][j-1]%longmax)%longmax;
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }

        if(dp[n][m] > INT_MAX){
            return -1;
        }
        else{
            return dp[n][m];
        }
    }
};