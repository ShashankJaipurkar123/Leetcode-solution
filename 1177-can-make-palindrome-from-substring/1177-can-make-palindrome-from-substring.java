class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        
        System.out.println(s.length());
        Bro bro = new Bro(s);
        
        List< Boolean > list = new ArrayList<>();

        for(int[] a : queries){
            int[] arr = bro.find(a[0],a[1]);
            int odd = 0;
            for(int b : arr) if(b % 2 != 0) odd++;
            odd /= 2;
            if(odd <= a[2]) list.add(true);
            else list.add(false);            
        }

        return list;
    }
}

class Bro{
    Map< Integer, Map < Integer, Integer >  > map = new HashMap<>();
    int start = 0, size = 1;
    int[] arr;
    public Bro(String s){
        int n = s.length();
        while(size < n) size *= 2;
        start = size - 1;
        for(int i = 0; i < n; i++){
            int c = s.charAt(i) - 97;
            Map< Integer , Integer > m = new HashMap<>();
            m.put(c,1);
            map.put(start + i, m);
        }
        for(int i = n + start; i < size * 2; i++){
            Map< Integer , Integer > m = new HashMap<>();
            m.put(25,0);
            map.put(i, m);
        }

        for(int i = start - 1; i >= 0; i--){
            Map< Integer , Integer > m = new HashMap<>();
            Map< Integer , Integer > h = map.get(i * 2 + 1);
            Map< Integer , Integer > c = map.get(i * 2 + 2);

            for(Integer q : h.keySet()){
                m.put(q,h.get(q));
            }
            for(Integer q : c.keySet()){
                m.put(q,m.getOrDefault(q,0) + c.get(q));
            }            
            map.put(i,m);
        }
        
    }
    public int[] find(int left, int right){
        arr = new int[26];
        find(left, right, 0,0,size - 1);
        return arr;
    }
    public void find(int left, int right, int ind, int lx, int rx){
        
        if(lx > right || rx < left) return;
        if(lx >= left && rx <= right){
            Map< Integer, Integer > m = map.get(ind);
            for(Integer l : m.keySet()){
                arr[l] += m.get(l);
            }
            return;
        }

        int mid = (lx + rx) / 2;

        find(left, right, ind * 2 + 1, lx, mid);
        find(left, right, ind * 2 + 2, mid + 1, rx);
    }
}