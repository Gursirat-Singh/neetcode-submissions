class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res,0,new ArrayList<>(),candidates,target);
        return res;
    }
    private void helper(List<List<Integer>> res,int index,List<Integer> list,int candidates[],int target){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(target<0)return;
        for(int i = index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1])continue;
            list.add(candidates[i]);
            helper(res,i+1,list,candidates,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}
