class Solution {
    fun findRepeatedDnaSequences(s: String): List<String> {
        
        if(s.length < 10) return listOf()
        
        var hashMap = mutableMapOf<String, Int>()
        var list: MutableList<String> = mutableListOf()

        for(i in 0..s.length - 10)
        {
            val n = hashMap.get(s.substring(i, i+10)) ?: 0
            hashMap[s.substring(i, i+10)] = n + 1
        }

        hashMap.forEach{ entry -> if(entry.value>1) list.add(entry.key)}

        return list
    }
}