class Solution {
public:
    string getHappyString(int n, int k) {
        //idea is to use queue data structure to store all the lexicographically sorted strig till length n & at last we will get the kth string if present else we will return empty string

        queue<string>q;
        q.push("a");
        q.push("b");
        q.push("c");
        while(q.front().length()<n){
            string temp=q.front();
            q.pop();
            if(temp[temp.length()-1]!='a'){
                q.push(temp+"a");
            }
            if(temp[temp.length()-1]!='b'){
                q.push(temp+"b");
            }
            if(temp[temp.length()-1]!='c'){
                q.push(temp+"c");
            }
        }

        string res="";
        while(!q.empty() && k){
            if(k==1){
                res=q.front();break;
            }
            q.pop();
            k--;
        }
        return res;
        
    }
};