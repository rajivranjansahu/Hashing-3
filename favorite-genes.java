// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class Main {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, 
                                                           Map<String, List<String>> genreMap) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songToGenre = new HashMap<>();

        // Build mapping from song to its genre.
        for (String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for (String song : songs) {
                songToGenre.put(song, genre);
            }
        }

        // For each user, count occurrences of each genre.
        for (String user : userMap.keySet()) {
            Map<String, Integer> count = new HashMap<>();
            int max = 0;
            res.put(user, new ArrayList<>());
            List<String> songs = userMap.get(user);

            for (String song : songs) {
                String genre = songToGenre.get(song);
                int c = count.getOrDefault(genre, 0) + 1;
                count.put(genre, c);
                max = Math.max(c, max);
            }

            // Add genres that have the highest count.
            for (String genre : count.keySet()) {
                if (count.get(genre) == max) {
                    res.get(user).add(genre);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

        HashMap<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);
        System.out.println(res);
    }
}
