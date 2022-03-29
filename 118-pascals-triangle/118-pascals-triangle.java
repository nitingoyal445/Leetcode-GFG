class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> res = new ArrayList<>();
            for(int j=0; j<i+1; j++){
                if(j==0 || j==i){
                    res.add(1);
                }else{
                    res.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
                }
            }
            triangle.add(res);
        }
        return triangle;
    }
}