class Solution {
public:

    vector<int> prefixArray(string &s){
    int n = s.length();
    vector<int> kmp(n+1);
    int i = 0,j = -1;
    kmp[0] = -1;
    while(i < n){
        while(j != -1 && s[j] != s[i]){
            j = kmp[j];      
        }
        j++; i++;     
        kmp[i] = j; 
    }
    
    return kmp;   
}
    
    
    string shortestPalindrome(string s) {
        
        string rev = s;
        reverse(rev.begin(),rev.end());
        
        string mx = s+'$'+rev;
        
        
        int n = mx.length();
        
        vector ps = prefixArray(mx);
        int v = ps[n];
        
        
        string res = s.substr(v);
        
        reverse(res.begin(),res.end());
        
        return res+s;
        
        
        
    }
};