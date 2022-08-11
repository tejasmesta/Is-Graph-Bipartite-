class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        
        Arrays.fill(color,-1);
        
        int n = graph.length;
        
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(!check(graph,i,color))
                {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean check(int[][] graph,int i,int[] color)
    {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(i);
        
        color[i] = 1;
        
        while(!q.isEmpty())
        {
            Integer n = q.remove();
            
            for(Integer it:graph[n])
            {
                if(color[it]==-1)
                {
                    color[it] = 1- color[n];
                    q.add(it);
                }
                else if(color[it]==color[n])
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}
