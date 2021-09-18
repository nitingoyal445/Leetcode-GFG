class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> res = new ArrayList<>();
        
        int i=0;
        int j=0;
        while(i < firstList.length && j< secondList.length){
            
            int st = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            if(st<=end){
                int[] subList = {st, end};
                res.add(subList);
            }
            if(firstList[i][1] < secondList[j][1]){
                i++;
            }
            else{
                j++;
            }   
        }
        return res.toArray(new int[res.size()][]);
    }
}