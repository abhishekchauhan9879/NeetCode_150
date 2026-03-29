class Twitter {

    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;

    private class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        time=0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId,  new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> queue = new PriorityQueue<>((a,b)->(b.time-a.time));

        // if the userId is not there, add userId
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for(int followee:followMap.get(userId)){
            if (tweetMap.containsKey(followee)) {
                for( Tweet t :tweetMap.get(followee)){
                    queue.offer(t);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int count=0;
        while(!queue.isEmpty() && count++<10){
            result.add(queue.poll().id);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
