// Approach: Iterate over each character in string, if char is not * then push the char in a stack, and if char is * pop the topmost element from the stack, at the end, reverse the stack and return the string.

class Solution {
    public String removeStars(String s) {
        String ans = "";
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '*' && !s.isEmpty()){
               st.pop();
            } else{
                st.push(s.charAt(i));
            }
        }
               
        while(!st.isEmpty()){
            char ch = st.pop();
            ans = ch + ans;
        }
        return ans;
        
    }
}