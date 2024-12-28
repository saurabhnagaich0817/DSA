class Solution {
    class Pair {
    int x,y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public boolean equals(Object o){
        if(this==o)
        return true;
        if(o==null||getClass()!=o.getClass()) 
        return false;
        Pair pair=(Pair) o;
        return x==pair.x&&y==pair.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
class Tuple implements Comparable<Tuple>{
    int x;
    int y;
    int wt;
    Tuple(int x,int y, int wt){
        this.x=x;
        this.y=y;
        this.wt=wt;
    }
    @Override
    public int compareTo(Tuple o){
        return this.wt-o.wt;
    }
}
    
    HashMap<Pair,HashMap<Pair,Integer>> graph=new HashMap<>();
    public int minCostConnectPoints(int[][] points) {
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int wt=(int)Math.abs(points[i][0]-points[j][0])+(int)Math.abs(points[i][1]-points[j][1]);
                graph.computeIfAbsent(new Pair(points[i][0],points[i][1]),k->new HashMap<>()).put(new Pair(points[j][0],points[j][1]),wt);
                graph.computeIfAbsent(new Pair(points[j][0],points[j][1]),k->new HashMap<>()).put(new Pair(points[i][0],points[i][1]),wt);
            }
        }
        PriorityQueue<Tuple> pq=new PriorityQueue<>();
        HashSet<Pair> visited=new HashSet<>();
        pq.offer(new Tuple(points[0][0], points[0][1], 0));int result=0;
        // visited.add(new Pair(points[0][0],points[0][1]));
        while(!pq.isEmpty()&&visited.size()<points.length){
            Tuple poll=pq.poll();
            if(visited.contains(new Pair(poll.x,poll.y)))
            continue;
            result+=poll.wt;
            visited.add(new Pair(poll.x,poll.y));
            HashMap<Pair,Integer> list=graph.getOrDefault(new Pair(poll.x,poll.y),new HashMap<>());
            for(Map.Entry<Pair,Integer> i:list.entrySet()){
                Pair p=i.getKey();int wt=i.getValue();
                if(!visited.contains(p))
                pq.offer(new Tuple(p.x,p.y,wt));
            }
        }
        return result;
    }
}