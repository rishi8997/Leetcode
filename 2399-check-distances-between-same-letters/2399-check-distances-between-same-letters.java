// Approach: Create a hashmap storing character and the number of letters between 2 occurences of that character. If a character appears only once it's value will be the index and it won't really matter. Then for each entry in distance[] we can check if it's equal to the corresponding value in map.

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, i - map.get(ch) - 1);
            } else {
                map.put(ch, i);
            }
        }
        int[] alpha = new int[26];
        for(int i=0; i<distance.length; i++){
            char ch = (char)('a' + i);
            if(map.containsKey(ch)){
                if(distance[i] != map.get(ch)){
                    return false;
                }
            }
        }
        return true;
        
    }
}