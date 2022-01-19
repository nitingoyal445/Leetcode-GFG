class Solution {
    public int numRabbits(int[] answers) {
         HashMap<Integer,Integer> map = new HashMap<>();
        for(int val: answers){
            map.put(val, map.getOrDefault(val,0)+1);
        }
        
        int ans = 0;
        for(int key : map.keySet()){
            int gs = key +1; // group size
            int reportees = map.get(key); 
            int nog = (int)Math.ceil(reportees*1.0 / gs*1.0);
            
            ans += nog * gs;
        }
        return ans;
    }
}