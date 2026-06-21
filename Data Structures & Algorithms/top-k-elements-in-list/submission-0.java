class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int n : freq.keySet()) {
            int f = freq.get(n);
            if (bucket[f] == null) bucket[f] = new ArrayList<>();
            bucket[f].add(n);
        }

        int[] res = new int[k];
        int idx = 0;

        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            if (bucket[i] != null) {
                for (int n : bucket[i]) {
                    res[idx++] = n;
                    if (idx == k) break;
                }
            }
        }

        return res;
    }
}
