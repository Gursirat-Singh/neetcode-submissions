class Tweet implements Comparable<Tweet>{
    int tweet_id;
    int time;
    Tweet(int id, int time) {
        this.tweet_id = id;
        this.time = time;
    }
    @Override
    public int compareTo(Tweet t) {
        return t.time - this.time;   
    }
}
class User {
    int user_id;
    List<Tweet> tweets;
    HashSet<Integer> followee;
    User(int id) {
        this.user_id = id;
        this.tweets = new ArrayList<>();
        this.followee = new HashSet<>();
    }
}
class Twitter {
    HashMap<Integer, User> map;
    int time;
    public Twitter() {
        map = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId))
            map.put(userId, new User(userId));

        map.get(userId).tweets.add(new Tweet(tweetId, ++time));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        if (map.containsKey(userId)) {
            User u = map.get(userId);
            int size = u.tweets.size() - 1;
            int n = 0;
            List<Integer> res = new ArrayList<>();
            for(int i = 0;i<u.tweets.size();i++){
                pq.add(u.tweets.get(i));
            }
            for(int fol : u.followee){
                User f = map.get(fol);
                for(int i = 0;i<f.tweets.size();i++){
                    pq.add(f.tweets.get(i));
                }
            }
            for(int i = 0;i<10;i++){
                if(pq.isEmpty())return res;
                res.add(pq.poll().tweet_id);
            }
            return res;
        } else {
            return new ArrayList<>();
        }
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        if (!map.containsKey(followerId)) {
            User u = new User(followerId);
            map.put(followerId, u);
        }
        if (!map.containsKey(followeeId)) {
            User u2 = new User(followeeId);
            map.put(followeeId, u2);
        }
        User u = map.get(followerId);
        u.followee.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;
        if (!map.containsKey(followerId))
            return;
        User u = map.get(followerId);
        u.followee.remove(followeeId);
    }
}
