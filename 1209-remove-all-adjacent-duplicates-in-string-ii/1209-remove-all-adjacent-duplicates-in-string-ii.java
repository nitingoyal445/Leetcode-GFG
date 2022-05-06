class Solution {
    class Pair{
        char ch;
        int count;
        
        public Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        
        if(s.length() == 1){
            return s;
        }
        Stack<Pair> st = new Stack<>();
        int i=0;
        while(i<s.length()){
            char val = s.charAt(i);
            if(!st.empty()){
                Pair p = st.peek();
                if(p.ch == val){
                    p.count++;
                    if(p.count==k){
                        st.pop();
                    }
                }else{
                    Pair newPair = new Pair(val, 1);
                    st.push(newPair);
                }
            }else{
                Pair newPair = new Pair(val, 1);
                st.push(newPair);
            }
            i++;
        }
        String str = "";
        while(st.size()!=0){
            Pair p = st.pop();
            char val = p.ch;
            int c = p.count;
            while(c-->0){
                str = val+str;
            }
        }
        return str;
    }
}