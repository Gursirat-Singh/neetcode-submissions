class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,nums,target,0,new ArrayList<>());
        return res;
    }
    private void helper(List<List<Integer>> res,int nums[],int target,int index,List<Integer> list){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(target<0)return;
        for(int i = index;i<nums.length;i++){
            list.add(nums[i]);
            helper(res,nums,target-nums[i],i,list);
            list.remove(list.size()-1);
        }
    }
}
