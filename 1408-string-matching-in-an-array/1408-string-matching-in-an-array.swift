class Solution {
    func stringMatching(_ words: [String]) -> [String] {
        words.filter { w in words.contains { $0 != w && $0.contains(w) } }
    }
}