import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TweetCounts {

    private Map<String, List<Integer>> map;

    public TweetCounts() {
        map = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        map.computeIfAbsent(tweetName, k -> new ArrayList<>()).add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int interval;

        if (freq.equals("minute")) {
            interval = 60;
        } else if (freq.equals("hour")) {
            interval = 3600;
        } else {
            interval = 86400;
        }

        int size = (endTime - startTime) / interval + 1;
        int[] counts = new int[size];

        List<Integer> times = map.getOrDefault(tweetName, new ArrayList<>());

        for (int time : times) {
            if (time >= startTime && time <= endTime) {
                counts[(time - startTime) / interval]++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int count : counts) {
            result.add(count);
        }

        return result;
    }
}