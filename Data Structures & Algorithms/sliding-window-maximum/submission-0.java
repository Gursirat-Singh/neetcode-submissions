class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int res[] = new int[nums.length-k+1];
        int left = 0;
        int i = 0;
        for(int right = 0;right<nums.length;right++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.pollLast();
            }
            dq.offerLast(right);
            if(dq.peekFirst()<left){
                dq.pollFirst();
            }
            if(right-left+1==k){
                res[left] = nums[dq.peekFirst()];
                left++;
            }
        }
        return res;
    }
}
