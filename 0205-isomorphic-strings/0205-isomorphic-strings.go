func isIsomorphic(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }
    sMap := make(map[byte]byte)
    tMap := make(map[byte]byte)
    for i := 0; i < len(s); i++ {
        sChar := s[i]
        tChar := t[i]
        if val, ok := sMap[sChar]; ok {
            if val != tChar {
                return false
            }
        } else {
            if _, ok := tMap[tChar]; ok {
                return false
            }
            sMap[sChar] = tChar
            tMap[tChar] = sChar
        }
    }
    return true
}