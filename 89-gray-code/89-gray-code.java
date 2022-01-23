class Solution {
    public List<Integer> grayCode(int n) {
        if(n<=1){
 	        List<Integer> list = new ArrayList<>();
 	        list.add(0);
 	        if(n==1){
 	           list.add(1); 
 	        }
 	        return list;
 	    }
 	    
 	    List<Integer> rlist = grayCode(n-1);
 	    List<Integer> mres = new ArrayList<>();
 	    int sz = rlist.size();
 	    for(int i=0;i<sz;i++){
 	         mres.add(rlist.get(i));
 	    }
 	    for(int i=sz-1; i>=0; i--){
 	        mres.add(rlist.get(i)+sz);
 	    }
 	    return mres;
    }
}