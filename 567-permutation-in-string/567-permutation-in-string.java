class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length()>s2.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        
        HashMap<Character, Integer> map2 = new HashMap<>();
        int i=0;
        for(i=0;i<s1.length()-1;i++){
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        int j=0;
        i-=1;
        while(i<s2.length()-1){
            i++;
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
            if(map1.equals(map2)){
                return true;
            }
            ch = s2.charAt(j);
            if(map2.get(ch)==1){
                map2.remove(ch);
            }else{
                map2.put(ch, map2.get(ch)-1);
            }
            j++;
        }
        return false;
    }
}