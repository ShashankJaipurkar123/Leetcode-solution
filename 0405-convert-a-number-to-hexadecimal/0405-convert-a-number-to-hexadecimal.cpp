class Solution {
public:
    string toHex(int num);
};
/*********************************************************************/
string Solution::toHex(int num) {
    bool sign{false};
    long int numAux = num;
    if (num < 0) {
        sign = true;
        numAux*=-1;
    } else if (numAux == 0) {
        return "0";
    }
    string binary = bitset<32>(numAux).to_string(), ans="";
    int i, j;
    unsigned long n=0;
    char c;
    if (sign == true) {
        /* negate bits */
        for (j = 31; j >= 0; --j) {
            if (binary[j] == '0') {
                binary[j] = '1';
            } else {
                binary[j] = '0';
            }
            n+=(binary[j]-'0')*pow(2,31-j);
        }
        /* plus one */
        ++n;
        binary = bitset<32>(n).to_string();
    }
    for (i = 31; i >= 0; i-=4, c = 0) {
        for (j = 0; j < 4; ++j) {
            c+=(binary[i-j]-'0')*pow(2, j);
        }
        /* ascii translation */
        if (c < 10) {
            c+=48;
        } else {
            c+=97-10;
        }
        ans+=c;
    }
    reverse(ans.begin(), ans.end());
    for (j = 0; j < 32; ++j) {
        if (ans[j] != '0') {
            break;
        }
    }
    ans = ans.substr(j, 32-j);
    return ans;
}