class Solution {
    class Points{
        int x1;
        int x2;
        int dist;
        Points(int x1,int x2,int dist){
                this.x1 = x1;
                this.x2 = x2;
                this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int dist = 0;
        PriorityQueue<Points> pq = new PriorityQueue<>((a,b)->b.dist - a.dist);
        for(int i = 0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            dist = x*x + y*y;
            pq.offer(new Points(points[i][0],points[i][1],dist));
            if(pq.size()>k)pq.poll();
        }
        int[][] arr = new int[k][2];
        for(int i = 0;i<k;i++){
            Points val = pq.poll();
            arr[i][0] = val.x1;
            arr[i][1] = val.x2;
        }
        return arr;
    }
}
