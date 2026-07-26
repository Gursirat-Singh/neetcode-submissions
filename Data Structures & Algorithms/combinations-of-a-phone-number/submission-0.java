class Solution {
    String combo[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)return new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(res,new StringBuilder(),digits,0);
        return res;
    }
    private void helper(List<String> res,StringBuilder sb,String digits,int index){
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }        
        String letter = combo[digits.charAt(index)-'0'];
        for(int i = 0;i<letter.length();i++){
            sb.append(letter.charAt(i));
            helper(res,sb,digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
