class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int lsp = intervals[0][0];
        int lep = intervals[0][1];
        
        
        for(int i=1;i<intervals.length;i++){
            int sp = intervals[i][0];
            int ep = intervals[i][1];
            
            if(lep<sp){
                //new interval is found
                int[] sublist = {lsp, lep};
                list.add(sublist);
                lsp = sp;
                lep = ep;
            }
            else if(lep< ep){
                //partially overlapping
                lep = ep;
            }
            else {
                //fully overlapping
                //nothing to do
            }
        }
        int[] sublist = {lsp,lep};
        list.add(sublist);
        return list.toArray(new int[list.size()][]);
    }
}