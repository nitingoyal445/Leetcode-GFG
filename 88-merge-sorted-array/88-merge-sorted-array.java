class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempArr=new int[m+n];
        int i=0;
        int a=0;
        int b=0;
        while(a<m && b<n){
            if(nums1[a]<nums2[b])
                tempArr[i++]=nums1[a++];
            else
                tempArr[i++]=nums2[b++];
        }
        while(a<m)
            tempArr[i++]=nums1[a++];
        while(b<n)
            tempArr[i++]=nums2[b++];
        for(int j=0;j<m+n;j++){
            nums1[j]=tempArr[j];
        }
    }
}