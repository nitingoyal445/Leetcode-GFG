class Solution {
    public String smallestSubsequence(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        Stack<Character> st = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        String ans = "";
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            //decrease count
            map.put(ch, map.get(ch)-1);
            //if character exists then continue
            if(set.contains(ch)){
                continue;
            }
            //if char is smaller then previous char in stack
            while(st.size()>0 && st.peek()>ch && map.get(st.peek())>0){
                char rem = st.pop();
                set.remove(rem);
            }
            st.push(ch);
            set.add(ch);
        }
        while(st.size()>0){
            char ch = st.pop();
            ans = ch+ans;
        }
        return ans;
    }
}