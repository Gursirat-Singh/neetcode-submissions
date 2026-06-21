class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double time[][] = new double[speed.length][2];
        for(int i = 0;i<position.length;i++){
            double key = target;
            key -= position[i];
            key /= speed[i];
            time[i][0] = key;
            time[i][1] = position[i];
        }
        Arrays.sort(time,(a,b)->Double.compare(b[1],a[1]));
        int count = 0;
        double maxTime = 0;
        double currTime = 0;
        int i = 0;
        while(i<time.length){
            currTime = time[i][0];
            if(currTime>maxTime){
                maxTime = currTime;
                count++;
                i++;
            }else{
                i++;
            }
        }
        return count;
    }
}
