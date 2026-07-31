class Node{
    Node arr[];
    boolean isEnd;
    public Node(){
        arr = new Node[26];
        isEnd = false;
    }
}
class PrefixTree {
    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            int idx = ch-'a';
            if(curr.arr[idx]==null) curr.arr[idx] = new Node();
            curr = curr.arr[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(curr.arr[idx]==null)return false;
            curr = curr.arr[idx];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch : prefix.toCharArray()){
            int idx = ch - 'a';
            if(curr.arr[idx]==null)return false;
            curr = curr.arr[idx];
        }
        return true;
    }
}
