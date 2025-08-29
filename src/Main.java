import java.util.*;

public class Main {
    public static void main(String[] args) {
        PostManager manager = new PostManager();

        String postTitle = "Java Programming Tips";
        int engagement = manager.calculateEngagement(150, 75, 25);
        String category = manager.getCategoryRating(engagement);

        System.out.println(manager.getPostStats(postTitle, engagement));
        System.out.println(manager.getPostStats(postTitle, engagement, category));
        String[] hashtags = {"#java", "#coding", "#programming", "#java", "#tips"};
        ArrayList<String> uniqueHashtags = manager.manageHashtags(hashtags);
        System.out.println("Unique Hashtags: " + uniqueHashtags);

        ArrayList<String> posts = new ArrayList<>(Arrays.asList("Java Programming Tips", "Advanced Java Tutorial", "Spring Boot Guide"));
        HashMap<String, Integer> engagementMap = new HashMap<>();
        engagementMap.put("Java Programming Tips", engagement);
        engagementMap.put("Advanced Java Tutorial", 800);
        engagementMap.put("Spring Boot Guide", 1200);

        LinkedList<String> trendingPosts = manager.findTrendingPosts(posts, engagementMap);
        System.out.println("Trending Posts: " + trendingPosts);
        HashSet<String> uniqueAuthors = manager.getUniqueAuthors("Alice", "Bob", "Alice", "Charlie", "Bob");
        System.out.println("Unique Authors: " + uniqueAuthors);
    }
}
