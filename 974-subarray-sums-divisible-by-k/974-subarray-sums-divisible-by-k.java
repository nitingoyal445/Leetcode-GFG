class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int rem = sum%k;
            if(rem<0){
                rem+=k;
            }
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}