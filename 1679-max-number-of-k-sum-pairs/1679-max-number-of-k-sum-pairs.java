class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<k && map.containsKey(nums[i])){
                
                if(map.containsKey(k-nums[i])){
                    if(nums[i]==k-nums[i]){
                        if(map.get(nums[i])<2){
                            continue;
                        }
                    }
                    count++;
                    if(map.get(k-nums[i])==1){
                        map.remove(k-nums[i]);
                    }else{
                        map.put(k-nums[i], map.get(k-nums[i])-1);
                    }
                }
                if(map.get(nums[i])==1){
                    map.remove(nums[i]);
                }else{
                    map.put(nums[i], map.get(nums[i])-1);
                }
                // System.out.println(map);
            } 
        }
        
        return count;
    }
}