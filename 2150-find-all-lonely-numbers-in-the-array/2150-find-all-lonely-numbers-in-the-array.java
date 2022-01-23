class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val, map.getOrDefault(val,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int val : map.keySet()){
            if(map.get(val) == 1){
                if(map.containsKey(val-1)== false && map.containsKey(val+1) == false ){
                    list.add(val);
                }
            }
        }
        return list;
    }
}