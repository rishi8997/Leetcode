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