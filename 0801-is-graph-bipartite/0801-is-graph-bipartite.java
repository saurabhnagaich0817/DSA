 class Solution {  
    public boolean isBipartite(int[][] graph) {  
        int n = graph.length;  
        int[] c = new int[n]; 
        Arrays.fill(c, -1);   
        
        for (int i = 0; i < n; i++) { 
            if (c[i] == -1) { 
                Queue<Integer> q = new LinkedList<>();  
                q.add(i);  
                c[i] = 0; 
                
                while (!q.isEmpty()) {  
                    int cr = q.poll();
                    for (int nbr : graph[cr]) { 
                        if (c[nbr] == -1) { 
                            c[nbr] = 1 - c[cr];   
                            q.add(nbr);  
                        } else if (c[nbr] == c[cr]) { 
                            return false; 
                        }  
                    }  
                }  
            }  
        }  
        return true; 
    }  
}