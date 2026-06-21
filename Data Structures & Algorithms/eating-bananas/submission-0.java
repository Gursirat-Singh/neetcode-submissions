class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int pile : piles){
            if(right<pile){
                right = pile;
            }
        }
        while(left <= right){
            int mid = left + (right - left)/2;
            int temp = 0;
            for(int pile : piles){
               temp += (pile + mid - 1)/mid;
            }
            if(temp>h){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
