class Solution {
    public boolean isAnagram(String s1, String s2) {
       if(s1.length()!=s2.length()) return false;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s1.length();i++){
		    char ch = s1.charAt(i);
		    map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		for(int i=0;i<s2.length();i++){
		    char ch = s2.charAt(i);
		    if(map.containsKey(ch)==false) return false;
		    map.put(ch, map.get(ch) - 1);
		    if(map.get(ch) == 0){
		        map.remove(ch);
		    }
		}
		return map.size()==0; 
    }
}