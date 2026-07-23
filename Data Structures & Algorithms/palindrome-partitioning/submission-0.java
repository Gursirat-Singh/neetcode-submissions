class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res,s,new ArrayList<>(),0);
        return res;
    }
    private void helper(List<List<String>> res,String s,List<String> list,int index){
        if(index==s.length()){
            res.add(new ArrayList<>(list));
            return;    
        }
        for(int i = index;i<s.length();i++){
           if(isPalin(s,index,i)){
                list.add(s.substring(index,i+1));
                helper(res,s,list,i+1);
                list.remove(list.size()-1);
           }
        }
    }
    private boolean isPalin(String str,int i,int j){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}
