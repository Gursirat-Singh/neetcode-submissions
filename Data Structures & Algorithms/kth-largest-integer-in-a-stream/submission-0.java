class KthLargest {
    PriorityQueue<Integer> pq;
    int find;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a,b)->b-a);
        find = k;
        for(int i = 0;i<nums.length;i++){
            pq.add(nums[i]);
        }
    }
    
    public int add(int key) {
        pq.add(key);
        if(pq.isEmpty() || pq.size()<find)return pq.peek();
        int val = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<find;i++){
            val = pq.poll();
            list.add(val);
        }
        for(int i = 0;i<list.size();i++){
            pq.add(list.get(i));
        }
        return val;
    }
}
