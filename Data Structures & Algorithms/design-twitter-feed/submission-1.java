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
class Node {
    Tweet tweet;
    int user_id;
    int index;
    Node(Tweet tweet,int user_id,int index){
        this.tweet = tweet;
        this.user_id = user_id;
        this.index = index;
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
    List<Integer> res = new ArrayList<>();

    if (!map.containsKey(userId))
        return res;

    PriorityQueue<Node> pq = new PriorityQueue<>(
        (a, b) -> b.tweet.time - a.tweet.time
    );

    User user = map.get(userId);

    if (!user.tweets.isEmpty()) {
        int last = user.tweets.size() - 1;
        pq.offer(new Node(user.tweets.get(last), userId, last));
    }

    for (int id : user.followee) {
        User f = map.get(id);
        if (!f.tweets.isEmpty()) {
            int last = f.tweets.size() - 1;
            pq.offer(new Node(f.tweets.get(last), id, last));
        }
    }

    while (!pq.isEmpty() && res.size() < 10) {
        Node curr = pq.poll();
        res.add(curr.tweet.tweet_id);

        if (curr.index > 0) {
            User u = map.get(curr.user_id);
            int prev = curr.index - 1;
            pq.offer(new Node(u.tweets.get(prev), curr.user_id, prev));
        }
    }

    return res;
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
