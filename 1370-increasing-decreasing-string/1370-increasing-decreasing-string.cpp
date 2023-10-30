class Solution {
public:
    string sortString(string s) {
        string result = "";
        int freq[26] = {0};

        for(int i = 0; i < s.length(); i++)
        {
            freq[s[i] - 97]++;
        }

        int n = s.length();

        while(n != 0)
        {
            for(int i = 0; i < 26; i++)
            {
                if(freq[i] >= 1)
                {
                    result += (char)(97 + i);
                    n--;
                    freq[i]--;
                }
            }
            for(int i = 25; i >= 0; i--)
            {
                if(freq[i] >= 1)
                {
                    result += (char)(97 + i);
                    n--;
                    freq[i]--;
                }
            }
        }

        return result;
    }
};