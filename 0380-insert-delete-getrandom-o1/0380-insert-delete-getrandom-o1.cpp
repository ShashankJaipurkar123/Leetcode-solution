class RandomizedSet {
public:
    set<int> s;
    RandomizedSet() {
        
    }
    
    bool insert(int val) {
        if(s.find(val)!=s.end()){
            return false;
        }
        s.insert(val);
        return true;
    }
    
    bool remove(int val) {
        if(s.find(val)!=s.end()){
            s.erase(val);
            return true;
        }
        return false;
    }
    
    int getRandom() {
        int n=rand()%s.size();
        auto it=s.begin();
        while(n--){
            it++;
        }
        return *it;
    }
};