class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(color[i]!=0) continue;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            color[i] = 1;
            while(!queue.isEmpty()){
                Integer node = queue.remove();
                for(int n : graph[node]){
                    if(color[n] == color[node]) return false;
                    else if(color[n]==0){
                        color[n] = -color[node];
                        queue.add(n);
                    }
                }
                
            }
              
        }
        return true;
    }
}