class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), i);
        }
        
        int start = 0;
        int last = 0;
        
        for(int i=0;i<s.length();i++){
            last = Math.max(last, map.get(s.charAt(i)));
            if(last == i){
                list.add(last-start+1);
                start = last+1;
            }
        }
        return list;
    }
}