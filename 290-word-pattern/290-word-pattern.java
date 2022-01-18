class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        
        if(pattern.length()!=str.length){
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            
            if(map.containsKey(ch)==true){
                if(!map.get(ch).equals(str[i])){
                    return false;
                }
            }else{
                if(set.contains(str[i])){
                    return false;
                }else{
                    map.put(ch,str[i]);
                    set.add(str[i]);
                }
            }
            
        }
        return true;
    }
}