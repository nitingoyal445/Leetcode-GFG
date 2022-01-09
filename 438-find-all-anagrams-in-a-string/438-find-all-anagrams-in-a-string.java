class Solution {
    
    public static boolean match(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap){
        for(Character ch: smap.keySet()){
            int val1= smap.getOrDefault(ch, -1);
            int val2= pmap.getOrDefault(ch, -1);
            
            if(val1 != val2){
                return false;
            }
        }
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()){
            ArrayList<Integer> list = new ArrayList<>();
            return list;
        }
        HashMap<Character, Integer> pmap = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch,0)+1);
        }
        
        HashMap<Character, Integer> smap = new HashMap<>();
        for(int i=0;i<p.length()-1;i++){
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        
        int i=p.length()-1;

        while(i<s.length()){
            //acquire
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch,0)+1);
            i++;
            //match
            if(match(smap,pmap)){
                list.add(i-p.length());
            }
            //release
            char relChar = s.charAt(i - p.length()); //-> releasing character
            smap.put(relChar, smap.get(relChar) - 1);
            if(smap.get(relChar) == 0){
                smap.remove(relChar);
            }
        }
        return list;
    }
}