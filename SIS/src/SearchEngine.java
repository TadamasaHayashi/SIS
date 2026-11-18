import java.util.*;
public class SearchEngine {

    // To-Do : Make overloaded method to accomatate Student class once made

    /* Using Search Engine Guide
    Make the object:
        SearchEngine se = new SearchEngine();

    Use the search:
        se.search(String, List, int)
        * String : what is being searched
        * List : that is being searched
        * int : the max amount of typos that can happen to be in the result list
    
    It will then return a list of 
    */

    // Makes the object (Constructor)
    public SearchEngine() {}

    // Searches for the closesest matches of the input in the list
    public List<String> search(String input, List<String> list, int maxTypos) {
        //Makes the input lower case (doesnt change the input to lower case itself but it lets me use it for searching)
        String lowerInput = input.toLowerCase();
        //Makes a map object where it stores objects as Key : Item <String, Integer>
        Map<String, Integer> scored = new HashMap<>();
        //Loops through the list
        for (String str : list) {
            //Make each thing in the list lower case (doesnt change the input to lower case itself but it lets me use it for searching)
            String lowerStr = str.toLowerCase();
            //If the input in its entireity is part of an object in a list
            if (lowerStr.contains(lowerInput)) {
                //It puts the full name with the priority of 0 (golf rules 0 is best no neg nums)
                scored.put(str, 0);
                //If its in already theres no need to finish this itteration of the loop
                continue;
            }
            //Gets the levenshteinDistance comparison between the input and the object in the list in its entirity and stops its comparing if the difference is more than maxTypos edits
            int best = levenshteinDistance(lowerInput, lowerStr, maxTypos);
            //Loops through each word in the object in the list breaking it into an array using any white-space character (regex uses \s as a whitespace character and + means 1 or more of that white-space character)
            //Each loop it compares if the new check is a closer comparison than the last check and only keeps the best result
            for (String eachStr : lowerStr.split("\\s+")) best = Math.min(best, levenshteinDistance(eachStr, lowerInput, maxTypos));
            //Filters by only adding to the map if there are no more than maxTypos typos
            if (best <= maxTypos) scored.put(str, best);
        }
        //list interface holding the ArrayList<String> object
        List<String> results = new ArrayList<>();
        //Adds each key in the map into the results
        results.addAll(scored.keySet());
        //it edits the results array to sort each of the keys in the array by the score it got by getting the result from the map using the key
        results.sort(Comparator.comparingInt(scored::get));
        //you better know what this does
        return results;
    }
    //Compares String a to String b and returns the amount of edits it would take to change one string into the other 1 edit = replacement removal or insertion of a char
    //this is so much easier to explain using a whiteboard or something so just ask me if you dont understand whats going on
    private int levenshteinDistance(String a, String b, int maxDiff) {
        //if the strings are completely different lengths theres no reason to continue so it returns one greater than the max amount of edits to be filtered later
        if (Math.abs(a.length() - b.length()) > maxDiff) return maxDiff + 1;
        //makes a 2d array to compare the strings with spacing to fill guides to calculate off of later
        int[][] db = new int[a.length() + 1][b.length() + 1];

        //2 loops to fill guide spaces
        for (int i = 0; i <= a.length(); i++) db[i][0] = i;
        for (int j = 0; j <= b.length(); j++) db[0][j] = j;

        //looping through 2d array
        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                //if the letters are the same it doesnt add a typo to the count
                int count = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;
                //gets the lowest amount of edits
                //if theres an insertion
                //if theres a deletion
                //if theres a replacement
                //it checks aganst the surrounding numbers in the array and adds edits if needed
                int currDiff = Math.min(Math.min(db[i - 1][j] + 1, db[i][j - 1] + 1), db[i - 1][j - 1] + count);
                //stops if the difference becomes greater then the number of maxDiff
                if (i == j && currDiff > maxDiff) return currDiff;
                //fills current cell based on surrounding cells
                db[i][j] = currDiff;
            }
        }
        //returns the bottom right space in the array which is the amound of edits needed thus the score
        return db[a.length()][b.length()];
    }
}
