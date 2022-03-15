class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Integer> st = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='('){
                st.push(i);
            }else if(s.charAt(i)==')'){
                if(st.isEmpty()){
                    set.add(i);
                }else{
                    st.pop();
                }
            }
        }
        set.addAll(st);
        
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                sb = sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}