class Node {
    Node arr[];
    boolean isEnd;
    public Node() {
        arr = new Node[26];
        isEnd = false;
    }
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.arr[idx] == null)
                curr.arr[idx] = new Node();
            curr = curr.arr[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, 0, word);
    }
    private boolean dfs(Node curr, int index, String word) {
        if (index == word.length())
            return curr.isEnd;
        char ch = word.charAt(index);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (curr.arr[i] != null && dfs(curr.arr[i], index + 1, word))
                    return true;
            }
            return false;
        }
        int idx = ch - 'a';
        if (curr.arr[idx] == null)
            return false;
        return dfs(curr.arr[idx],index+1,word);
    }
}
