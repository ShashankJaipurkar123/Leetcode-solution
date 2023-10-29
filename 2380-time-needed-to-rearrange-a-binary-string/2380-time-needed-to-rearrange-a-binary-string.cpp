class Solution {
public:
    int secondsToRemoveOccurrences(string s) {
        int cnt=0;int st=0;int n=s.length();bool flag=false;
        for(int i=0;i<=n;i++){
            for(int j=0;j<n-1;j++){
                if(s[j]=='0'&&s[j+1]=='1'){swap(s[j],s[j+1]);j++;flag=true;}
            }
            if(flag==false){return i;}flag=false;
        }
        return n;
    }
};