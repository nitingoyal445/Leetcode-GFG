class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==1){
            return false;
        }
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch=='{' || ch=='['){
                st.push(ch);
            }else if(ch==')' && st.size()>0){
                char rem = st.pop();
                if(rem != '('){
                    return false;
                }
            }else if(ch=='}' && st.size()>0){
                char rem = st.pop();
                if(rem != '{'){
                    return false;
                }
            }else if(ch==']' && st.size()>0){
                char rem = st.pop();
                if(rem != '['){
                    return false;
                }
            }else{
                return false;
            } 
        }
        
        return st.size()==0;
    }
}