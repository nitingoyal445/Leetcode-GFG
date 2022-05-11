class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        int i=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch==')'){
                if(st.size()>0 && st.peek()=='('){
                    st.pop();
                }else{
                    return false;
                }
                
            }else if(ch=='}'){
                if(st.size()>0 && st.peek()=='{'){
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch==']'){
                if(st.size()>0 && st.peek()=='['){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(ch);
            }
            i++;
        }
        return st.size()==0;
    }
}