class Solution {
    //approach - 1
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<32;i++){
            int count = 0;
            int bm = (1<<i);
            for(int val : nums){
                if((val&bm)==bm){
                    count++;
                }
            }
            if(count%3==1){
                res = res | bm;
            }
        }
        return res;
    }
    
    //approach - 2  //works for positive number
//     public int singleNumber(int[] arr){
//        int tn = Integer.MAX_VALUE; // 3n
//        int tnp1 = 0; // 3n+1
//        int tnp2 = 0; // 3n+2

//        for(int i=0;i<arr.length;i++){
//            int cwtn = arr[i] & tn;
//            int cwtnp1 = arr[i] & tnp1;
//            int cwtnp2 = arr[i] & tnp2;

//            tn = tn & (~cwtn);
//            tnp1 = tnp1 | cwtn;

//            tnp1 = tnp1 & (~cwtnp1);
//            tnp2 = tnp2 | cwtnp1;

//            tnp2 = tnp2 & (~cwtnp2);
//            tn = tn | cwtnp2;   
//         }
//         return tnp1;
//     }
}