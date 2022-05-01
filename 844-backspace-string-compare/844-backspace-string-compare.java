class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='#' && stack1.isEmpty()){
                
            }
            else if(c=='#'){
                stack1.pop();
            }else{
                stack1.push(c);
            }
        }
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if(c=='#' && stack2.isEmpty()){
                
            }
            else if(c=='#'){
                stack2.pop();
            }else{
                stack2.push(c);
            }
        }
        if(stack1.size() != stack2.size()){
            return false;
        }
        String st1="";
        String st2="";
        while(!stack1.isEmpty()){
            st1 += stack1.pop();
            st2 += stack2.pop();
        }
        if(st1.equals(st2)) return true;
        
        return false;
    }
}