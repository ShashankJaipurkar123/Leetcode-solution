class Solution {
public:
    char repeatedCharacter(string s) {
        unordered_map<char, int> mp;

        for(int i=0; i<size(s); i++)
        {
            mp[s[i]]++;
            
            if(mp[s[i]] == 2)
                return s[i];
        }
        return -1;

    }
};