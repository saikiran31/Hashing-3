import java.util.*;

public class FavoriteGenres {

    public static Map<String, List<String>> favoriteGenres(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songToGenre = new HashMap<>();
        for (String genre : genreMap.keySet()) {
            for (String song : genreMap.get(genre)) {
                songToGenre.put(song, genre);
            }
        }

        for (String user : userMap.keySet()) {
            Map<String, Integer> genreCount = new HashMap<>();
            int max = 0;
            for (String song : userMap.get(user)) {
                String genre = songToGenre.get(song);
                if (genre != null) {
                    genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
                    max = Math.max(max, genreCount.get(genre));
                }
            }

            List<String> favGenres = new ArrayList<>();
            for (String genre : genreCount.keySet()) {
                if (genreCount.get(genre) == max) {
                    favGenres.add(genre);
                }
            }

            res.put(user, favGenres);
        }

        return res;
    }

    public static void main(String[] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));

        Map<String, List<String>> result = favoriteGenres(userSongs, songGenres);

        for (String user : result.keySet()) {
            System.out.println(user + ": " + result.get(user));
        }
    }
}

/*
 *
 u = number of users

s = total number of songs across all users

g = number of genres

t = total number of songs across all genres (in genreMap)

//tc: O(t + s + u * g)

//sc: O(t + u * g)
 */