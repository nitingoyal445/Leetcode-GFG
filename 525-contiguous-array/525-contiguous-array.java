class Solution {
    public int findMaxLength(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int mlen=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                sum+=-1;
            }else{
                sum+=1;
            }
            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                mlen = len>mlen?len:mlen;
            }else{
                map.put(sum, i);
            }
        }
        return mlen;
    }
}