class TrieNode:
    def __init__(self, letter=None):
        self.letter = letter
        self.children = {}
        self.isEnd = False

    def __repr__(self):
        return str(self.letter)


class WordDictionary:

    def __init__(self):
        self.root = TrieNode("*")
        self.lengths = set()
        self.cache = {}

    def addWord(self, word: str) -> None:
        current = self.root
        for i in word:
            if i not in current.children:
                current.children[i] = TrieNode(i)
            current = current.children[i]
        current.isEnd = True
        self.lengths.add(len(word))

    def search(self, word: str) -> bool:
        if len(word) not in self.lengths:
            return False
        current = self.root
        def dfs(word, current):
            if len(word) == 0 and current.isEnd:
                return True
            if len(word) == 0:
                return False
            v = False
            if word[0] == ".":
                for i in current.children:
                    v = dfs(word[1:], current.children[i])
                    if v:
                        break
            else:
                if word[0] not in current.children:
                    return False
                v = dfs(word[1:], current.children[word[0]])
            return v

        v = dfs(word, current)
        return v