class Solution {
    public int trap(int[] height) {
        int left = 0, leftMax = 0;
        int right = height.length - 1,rightMax = 0;
        int res = 0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax){
                    leftMax = height[left];
                }
                res += leftMax - height[left];
                left++;
            }
            else{
                if(height[right]>=rightMax){
                    rightMax = height[right];
                }
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
