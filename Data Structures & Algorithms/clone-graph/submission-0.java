/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(node.val);
        List<Node> temp = node.neighbors;
        map.put(node, root);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node demo = queue.poll();
            List<Node> nei = demo.neighbors;
            for (int j = 0; j < nei.size(); j++) {
                Node c = nei.get(j);
                if (!map.containsKey(c)) {
                    Node dummy = new Node(c.val);
                    queue.offer(c);
                    map.put(c, dummy);
                }
                map.get(demo).neighbors.add(map.get(c));
            }
        }
        return root;
    }
}