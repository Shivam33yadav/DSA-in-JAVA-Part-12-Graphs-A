
import java.util.*;
public class IDijkastraAlgo { //T.C -> V + ElogV   for pair (Elogv) and for boolean vis (V) .......... if we do not use pq then it will O(V^2)
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;

        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i =0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    //Pair Class  -> Greedy
    static class Pair implements Comparable<Pair>{ // implements comparable interface aur wo work krega meri pair class k upar
        int n;
        int path;

        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        } 
        
        @Override                           //jb bhi comparable ko implement krte h tab override krke hume compareTo function ko Override krna pdta h hume apni class k andr ? kyuki humhre object k andr compare krne k parameter nhi btaye ki object node k base pe compare hogi ya path k basis pe to use define krna hoga
        public int compareTo(Pair p2) {
            return this.path - p2.path; //means jo value choti h use PriorityQueue pehle return krga (path based Sorting for my pairs)
        }   
    }
    public static void dijkstra(ArrayList<Edge> graph[], int src) {
       int dist[] = new int[graph.length]; //dist[i] means src to i 
       for(int i = 0; i< graph.length; i++) {
        if(i != src) { //jb source hota h tab 0 hota h aur src k equal nhi tb initialize with infinite
            dist[i] = Integer.MAX_VALUE; //+Infinite;
        } 
       }
       boolean vis[] = new boolean[graph.length]; 
       //Priority Queue
       PriorityQueue<Pair> pq = new PriorityQueue<>(); //Pq m shortest distance chiye to uska method  -> Comparable<pair>
       pq.add(new Pair(src, 0)); //ek pair store kraya jiski src to dist 0, 0
       //for BFS -> loop
       while(!pq.isEmpty()) { //jb tak queu khali nhi ho jati
          Pair curr = pq.remove(); //jiska shortest dist hoga wo q se bahr aa jaega 
          if( !vis[curr.n]) { //jb visited nhi h tb visited kro (curr.n ek pair value h)
            vis[curr.n] = true; //  .n means node ->ab jb visited bna diya ab uske neighbour k dist ko update krne bale h
            //neighbours
            for(int i =0; i<graph[curr.n].size(); i++) {
                Edge e = graph[curr.n].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

               if(dist[u]+wt < dist[v])  { //update distance of src to v
                dist[v] = dist[u] + wt;//update hone k baad pq m push
                pq.add(new Pair(v, dist[v]));
               }

            }

          }
       }
       //print all source to vertices shortest distance 
       for(int i =0; i<dist.length; i++) {
        System.out.println(dist[i]+" ");
       }
     System.out.println();
    }
    public static void main(String[] args) {
        int V = 6;
       ArrayList<Edge> graph[] = new ArrayList[V];
       createGraph(graph);
       
       int src = 0; //let
       dijkstra(graph, src);
       
    }
}