class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int min = stack.pop();
                if(stack.isEmpty()){
                    ans = Math.max(ans,heights[min]*i);
                }else{
                    int width = i - stack.peek() - 1;
                    ans = Math.max(ans,width*heights[min]);
                }
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int min = stack.pop();
            if(stack.isEmpty()){
                ans = Math.max(ans,heights[min]*heights.length);
            }else{
                int width = heights.length - stack.peek() - 1;
                ans = Math.max(ans,width*heights[min]);
            }   
        }
        return ans;
    }
}
