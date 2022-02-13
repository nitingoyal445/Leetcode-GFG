class Solution {
    public int minimumOperations(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        
        
        HashMap<Integer, Integer> evenMap = new HashMap<>();
        HashMap<Integer, Integer> oddMap = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                evenMap.put(nums[i],evenMap.getOrDefault(nums[i],0)+1);
            }else{
                oddMap.put(nums[i],oddMap.getOrDefault(nums[i],0)+1);
            }
        }
        
        for(int val : oddMap.keySet()){
            if(evenMap.containsKey(val)){
                if(evenMap.get(val)>oddMap.get(val)){
                    oddMap.put(val,0);
                }else{
                    evenMap.put(val,0);
                }
            }
        }
        
        int oddMax = 0;
        int evenMax = 0;
        
        for(int val : oddMap.keySet()){
            oddMax = Math.max(oddMax, oddMap.get(val));
        }
        for(int val : evenMap.keySet()){
            evenMax = Math.max(evenMax, evenMap.get(val));
        }
        return nums.length - oddMax-evenMax;
    }
}