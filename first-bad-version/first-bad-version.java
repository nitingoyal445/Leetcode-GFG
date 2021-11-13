/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int idx = -1;
        int lo = 1;
        int hi = n;

        while(lo<=hi){
            int mid = lo+(hi-lo)/2;

            if(isBadVersion(mid)){
                idx = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }

        return idx;
    }
}