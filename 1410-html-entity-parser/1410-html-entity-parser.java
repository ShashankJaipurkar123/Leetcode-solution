class Solution {
    public String entityParser(String text) {
        Map<String, Character> map = init_map();
        StringBuilder str = new StringBuilder();
        int i=0, j=0;
        while(i<text.length()){
            if(text.charAt(i)=='&'){
                StringBuilder s = new StringBuilder();
                j=i+1;
                while(j<text.length() && text.charAt(j)!=';' && text.charAt(j)!='&') {
                    s.append(text.charAt(j));
                    j++;
                }
                if(j<text.length() && text.charAt(j)!='&'){
                    char c = map.getOrDefault(s.toString(), '+');
                    if(c!='+') {
                        str.append(c);
                        i=j+1;
                        continue;
                    }
                }
                str.append(text.charAt(i));
                i++;
            }else{
                str.append(text.charAt(i));
                i++;
            }
        }
        return str.toString();
    }

    public Map<String, Character> init_map() {
        Map<String, Character> map = new HashMap<String, Character>();
        map.put("quot", '\"');
        map.put("apos", '\'');
        map.put("amp", '&');
        map.put("gt", '>');
        map.put("lt", '<');
        map.put("frasl", '/');
        return map;
    }
}