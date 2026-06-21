class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        } 
        int n = nums.length;
        List<Integer> bucket[] = new ArrayList[n+1];
        for(int i : map.keySet()){
            int f = map.get(i);
            if(bucket[f]==null) bucket[f] = new ArrayList<>();
            bucket[f].add(i);
        }
        int res[] = new int[k];
        int idx = 0;
        for(int i = n;i>=0 && idx < k;i--){
            if(bucket[i]!=null){
                for(int j : bucket[i]){
                    res[idx++] = j;
                    if(idx==k)break;
                }
            }
        }
        return res;
    }
}
