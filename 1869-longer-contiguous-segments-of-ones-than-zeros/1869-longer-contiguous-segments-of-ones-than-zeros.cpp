class Solution {
public:
    bool checkZeroOnes(string s) {
        int cnt1=0;   //count no of 1s
        int cnt0=0;   //count no of 0s
        int max1=0;
        int max0=0;

        for(int i=0;i<s.length();i++){
            if(s[i]=='1'){
                cnt1++;
                max1=max(max1,cnt1);
                cnt0=0;    //if 1s appears after 0s then reset the cnt0 to 0
            }
            if(s[i]=='0'){
                cnt0++;
                max0=max(max0,cnt0);
                cnt1=0;   //if 0s appears after 1s then reset the cnt1 to 0
            }
        }
        return max1>max0;
    }
};