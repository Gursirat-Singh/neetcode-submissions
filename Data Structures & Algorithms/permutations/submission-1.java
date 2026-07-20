class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean check[] = new boolean[nums.length];
        Arrays.fill(check,false);
        helper(0,nums,res,new ArrayList<>(),check);
        return res;
    }
    private void helper(int index,int nums[],List<List<Integer>> res,List<Integer> list,boolean check[]){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(check[i])continue;
            else{
                check[i]=true;
                list.add(nums[i]);
                helper(i+1,nums,res,list,check);
                list.remove(list.size()-1);
                check[i]=false;
            }
        }
    }
}
