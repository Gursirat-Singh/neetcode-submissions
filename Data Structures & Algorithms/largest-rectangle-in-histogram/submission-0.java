class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        for(int i = 0;i<heights.length;i++){
            int min = heights[i];
            for(int j = i;j<heights.length;j++){
                min = Math.min(min,heights[j]);
                int width = j-i+1;
                ans = Math.max(ans,width*min);
            }
        }
        return ans;
    }
}
