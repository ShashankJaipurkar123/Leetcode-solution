class Solution {
public:
// function to check whether calculated temporary answer is a valid split
    bool isValid(string& ans, string& s) {
        string temp = ans;
        temp.erase(remove(temp.begin(), temp.end(), ' '), temp.end());
        return temp == s;
    }
// recursive function to calculate all possible splits for string s
    void solve(int i, string& s,vector<string>& wordDict, string& ans, vector<string>& res) {
// base condition checked to avoid stack overflow
        if (i >= s.size()) {
            if (isValid(ans, s)) {
// push the valid answer to our final answer
                res.push_back(ans);
            }
            return;
        }
// iterate throughout the word dictionary
        for (string word : wordDict) {
            int n = word.size();
            if (i + n <= s.size() && s.substr(i, n) == word) {
                string temp = ans;
                if (!temp.empty())
                    temp += " ";
                temp += word;
// recursively call the function for next index of string s
                solve(i + n, s, wordDict, temp, res);
            }
        }
    }
    vector<string> wordBreak(string s, vector<string>& wordDict) {
// to store the final answer
        vector<string> res;
// to store the valid strings splits
        string ans;
// call the recursive function to calculate the answer 
        solve(0, s, wordDict, ans, res);
        return res;
    }
};