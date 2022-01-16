class Solution {
    public int minSteps(String str1, String str2) {
		int count=0;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str1.length();i++){
		    char ch = str1.charAt(i);
		    map.put(ch, map.getOrDefault(ch, 0) +1);
		}
		
		for(int i=0;i<str2.length();i++){
		    char ch = str2.charAt(i);
		    if(map.containsKey(ch)){
		        if(map.get(ch)==1){
		            map.remove(ch);
		        }else{
		            map.put(ch, map.get(ch)-1);
		        }
		    }
		}
		
		for(Character ch:map.keySet()){
		    count+=map.get(ch);
		}

		return count;
    }
}