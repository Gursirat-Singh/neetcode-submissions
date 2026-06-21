class Solution {

    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for(String token : tokens){

            if(!token.equals("+") &&
               !token.equals("-") &&
               !token.equals("*") &&
               !token.equals("/")) {

                stack.push(token);
            }

            else {

                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());

                int res = 0;

                if(token.equals("+")){
                    res = second + first;
                }

                else if(token.equals("*")){
                    res = second * first;
                }

                else if(token.equals("-")){
                    res = second - first;
                }

                else{
                    res = second / first;
                }

                stack.push(Integer.toString(res));
            }
        }

        return Integer.parseInt(stack.peek());
    }
}