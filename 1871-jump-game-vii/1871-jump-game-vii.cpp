class Solution {
public:
    int jg7(int i,string &s,vector<int> &dp,int mj,int maj,set<int> &set){
        int n=s.size();
        if(i==n-1)return 1;
        if(dp[i]!=-1)return dp[i];int a=0,k=min(i+maj,n-1);
        int b=0;
        while(1){{
            auto it=set.lower_bound(i+mj);
            if(it==set.end() || *it>k)break;
                auto j=*it;set.erase(j);
                if(dp[j]==-1)
                dp[j]=jg7(j,s,dp,mj,maj,set);b=dp[j];
            }a=(a||b);if(a==1)break;
        }
        return dp[i]=a;
    }
    bool canReach(string s, int minJump, int maxJump) {
        int n=s.size();
        vector<int> dp(n+1,-1);set<int> set;
        for(int i=0;i<n;i++)if(s[i]=='0')set.insert(i);
        return jg7(0,s,dp,minJump,maxJump,set);
    }
};