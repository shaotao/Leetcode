import java.io.*;
import java.util.*;


class DesignTwitter
{
    public static void main(String[] args)
    {
	System.out.println("=== Design Twitter ===");

        List<Integer> l = null;
        Twitter twitter = new Twitter();
        
        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);
        
        // User 1's news feed should return a list with 1 tweet id -> [5].
        l = twitter.getNewsFeed(1);
        System.out.println("feed of user 1 = "+l);
        
        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        l = twitter.getNewsFeed(1);
        System.out.println("feed of user 1 = "+l);

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        l = twitter.getNewsFeed(1);
        System.out.println("feed of user 1 = "+l);
    }
}

class User
{
    int id;
    HashMap<Integer, User> followee_map = null;
    // tweet index is not tweet id, idx provides global ordering
    ArrayList<Integer> tweet_idx_list = null;
    
    public User(int id) {
        this.id = id;
        followee_map = new HashMap<Integer, User>();
        tweet_idx_list = new ArrayList<Integer>();
    }

    public void post(int idx) {
        tweet_idx_list.add(idx);
    }

    public boolean follow(int followeeId, User user) {
        if(user == null || followeeId == id) { return false; }
        followee_map.put(followeeId, user);
        return true;
    }

    public boolean unfollow(int followeeId) {
        return (followee_map.remove(followeeId)!=null);
    }

    public HashMap<Integer, User> getFolloweeMap() {
        return followee_map;
    }

    public ArrayList<Integer> getTweetIdxList() {
        return tweet_idx_list;
    }
}

class Twitter
{
    HashMap<Integer, User> users;
    ArrayList<Integer> tweets;
    
    public Twitter() {
        users = new HashMap<Integer, User>();
        tweets = new ArrayList<Integer>();
    }

    public void postTweet(int userId, int tweetId) {
        User user = users.get(userId);
        if(user == null) {
            user = new User(userId);
            users.put(userId, user);
        }

        tweets.add(tweetId);
        user.post(tweets.size()-1);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ret = new ArrayList<Integer>();

        ArrayList<ArrayList<Integer>> list_of_idx_list = new ArrayList<ArrayList<Integer>>();
        
        User user = users.get(userId);
        if(user == null) { return ret; }
        HashMap<Integer, User> followees = user.getFolloweeMap();

        list_of_idx_list.add(user.getTweetIdxList());
        for(Map.Entry<Integer, User> entry : followees.entrySet()) {
            list_of_idx_list.add(entry.getValue().getTweetIdxList());
        }

        // scan list_of_idx_list backwards to get the most recent 10 tweets
        int size = list_of_idx_list.size();
        ArrayList<Integer> tip_list = new ArrayList<Integer>();
        for(int i = 0; i < size; i++) {
            tip_list.add(list_of_idx_list.get(i).size()-1);
        }

        // scan for most recent 10
        for(int count_feed = 0; count_feed < 10; count_feed++) {
            // idx of the most recent tweet, this is NOT the tweet ID yet
            // call tweets.get(most) to get tweet ID and put to ret
            int most_recent_tweet_idx = -1;

            // which tip provides the tweet, need to move idx backward by 1
            int tip_idx = -1;

            // scan each tip, find most_recent_tweet_idx and tip_idx
            for(int i = 0; i < size; i++) {
                
                int tmp = tip_list.get(i);
                if(tmp < 0) { continue; }

                int idx = list_of_idx_list.get(i).get(tmp);

                if(most_recent_tweet_idx < idx) {
                    most_recent_tweet_idx = idx;
                    tip_idx = i;
                }
            }

            if(most_recent_tweet_idx < 0) {
                // no more tweets
                break;
            }

            // or else, get tweet id from tweet_idx and move tip backward
            ret.add(tweets.get(most_recent_tweet_idx));
            tip_list.set(tip_idx, tip_list.get(tip_idx)-1);
        }
        
        return ret;
    }

    public void follow(int followerId, int followeeId) {
        User follower = users.get(followerId);
        if(follower == null) {
            follower = new User(followerId);
            users.put(followerId, follower);
        }
        User followee = users.get(followeeId);
        if(followee == null) {
            followee = new User(followeeId);
            users.put(followeeId, followee);
        }
        
        follower.follow(followeeId, followee);
    }

    public void unfollow(int followerId, int followeeId) {
        User follower = users.get(followerId);
        if(follower == null) {
            follower = new User(followerId);
            users.put(followerId, follower);
        }
        User followee = users.get(followeeId);
        if(followee == null) {
            followee = new User(followeeId);
            users.put(followeeId, followee);
        }
        
        follower.unfollow(followeeId);        
    }
}
