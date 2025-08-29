import java.util.*;

public class PostManager {

    public int calculateEngagement(int... interactions) {
        if (interactions == null || interactions.length == 0) {
            return 0;
        }
        int total = 0;
        for (int interaction : interactions) {
            total += interaction;
        }
        return total;
    }

    public String getCategoryRating(int engagementScore) {
        if (engagementScore >= 1000) return "Viral";
        else if (engagementScore >= 500) return "Popular";
        else if (engagementScore >= 100) return "Good";
        else if (engagementScore >= 50) return "Low";
        else return "Poor";
    }

    public String getPostStats(String postTitle, int engagementScore) {
        return "Post: " + postTitle + "\nEngagement Score: " + engagementScore;
    }

    public String getPostStats(String postTitle, int engagementScore, String category) {
        return "Post: " + postTitle + "\nEngagement Score: " + engagementScore + "\nCategory: " + category;
    }

    public ArrayList<String> manageHashtags(String[] hashtags) {
        if (hashtags == null) return new ArrayList<>();

        String[] fixedSize = new String[5];
        for (int i = 0; i < Math.min(hashtags.length, 5); i++) {
            fixedSize[i] = hashtags[i];
        }

        HashSet<String> uniqueSet = new HashSet<>(Arrays.asList(fixedSize));
        uniqueSet.remove(null); // clean nulls
        return new ArrayList<>(uniqueSet);
    }
  
    public LinkedList<String> findTrendingPosts(ArrayList<String> posts, HashMap<String, Integer> postEngagement) {
        LinkedList<String> trending = new LinkedList<>();
        if (posts == null || postEngagement == null) return trending;

        for (String post : posts) {
            int score = postEngagement.getOrDefault(post, 0);
            if (score > 500) {
                trending.add(post);
            }
        }
        return trending;
    }

    public HashSet<String> getUniqueAuthors(String... authors) {
        if (authors == null) return new HashSet<>();
        return new HashSet<>(Arrays.asList(authors));
    }
}
