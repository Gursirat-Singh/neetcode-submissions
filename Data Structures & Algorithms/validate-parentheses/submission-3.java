class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char val : s.toCharArray()){
            if(val == '(' || val == '[' || val == '{'){
                st.push(val);
            }
            else
            {
                if(st.isEmpty())
                    return false;
                char top = st.pop();
                if((val == '}' && top != '{') || (val == ')' && top != '(') || (val == ']' && top != '[')){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
