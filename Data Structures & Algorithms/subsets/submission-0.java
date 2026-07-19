class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,nums,new ArrayList<>(),0);
        return res;
    }
    private void helper(List<List<Integer>> res,int[] nums,List<Integer> list,int index){
        res.add(new ArrayList<>(list));
        for(int i = index;i<nums.length;i++){
            list.add(nums[i]);
            helper(res,nums,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
