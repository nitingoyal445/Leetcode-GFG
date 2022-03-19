class Solution {
    
    class Edge{
        int src;
        int nbr;
        
        Edge(){
            this.src = 0;
            this.nbr = 0;
        }
        
        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    
    
     
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<Edge>[] graph = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
    
        for(int i=0;i<edges.length;i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }
        
        boolean[] visited = new boolean[n];
        return hasPath(graph, source, destination, visited);     
    }
    
    private static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        
        if(src == dest){
            return true;
        }
        visited[src] = true;
        for(Edge edge : graph[src]){
            if(visited[edge.nbr]==false){
                boolean hasPath = hasPath(graph, edge.nbr, dest, visited);
                if(hasPath==true){
                    return true;
                }
            }
        }
        return false;
    }
}