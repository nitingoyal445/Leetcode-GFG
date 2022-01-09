class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++){
		    int val = arr[i];
		    int rem = val%k;
            if(rem < 0){
                rem+=k;
            }
		    map.put(rem, map.getOrDefault(rem, 0) + 1);
		}
		for(int val : arr){
		    int rem = val%k;
            if(rem < 0){
                rem+=k;
            }
		    if(rem%k==0){
		        int freq = map.get(rem);
		        if(freq%2==1){
		            return false;
		        }
		    }else if(2*rem == k){
		        int freq = map.get(rem);
		        if(freq%2==1){
		            return false;
		        }
		    }else{
		        int freq = map.get(rem);
                int oFreq = map.getOrDefault(k-rem,0);
		        if(freq!=oFreq){
		            return false;
		        }
		    }
		}
		return true;
    }
}