class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i = 0;i<stones.length;i++){
            pq.offer(stones[i]);
        }
        while(pq.size()!=1 && !pq.isEmpty()){
            int val1 = pq.poll();
            int val2 = pq.poll();
            int collide = val1-val2;
            if(collide != 0)pq.offer(collide);
        }
        return (pq.peek()==null)?0:pq.peek();
    }
}
