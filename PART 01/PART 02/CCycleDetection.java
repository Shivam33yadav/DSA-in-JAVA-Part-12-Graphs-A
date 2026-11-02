import java.util.*;
public class CCycleDetection {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
         for(int i = 0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
         }

         graph[0].add(new Edge(0,1));
         graph[0].add(new Edge(0,2));
         graph[0].add(new Edge(0,3));

         graph[1].add(new Edge(1, 0));
         graph[1].add(new Edge(1, 2));

         graph[2].add(new Edge(2, 0));
         graph[2].add(new Edge(2, 1));

         graph[3].add(new Edge(3, 0));
         graph[3].add(new Edge(3, 4));

         graph[4].add(new Edge(4, 3));

    } 
    //cycle detection code
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i<graph.length; i++) {
            if(!vis[i]) { //agr vis nhi h to vis krayenge
              if(detectCycleUtil(graph, vis, i, -1)){ // jahn se suru krte h uska parent nhi hota so -1 and i is the curr node
              return true;
              // cycle exist in one of the parts
            }
        }
    }
    return false;
}
    //actual kaaam
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) { // 4 parameters
         vis[curr] =true;

         for(int i =0; i<graph[curr].size(); i++) { // T.C -> O(V + E)
            Edge e = graph[curr].get(i);
            //CASE -> 03
           // if(!vis[e.dest] && detectCycleUtil(graph, vis, e.dest, curr)) { //agr neighbour not visited h aur detectcycleutil call krne pr agr true de diya means cycle exist
               // return true;

               if(!vis[e.dest]) {
                if(detectCycleUtil(graph, vis, e.dest, par)){
                    return true;
                }
                    return true;
               }
            
            //CASE -> 01
            else if(vis[e.dest] && e.dest != par) {// visited h pr parent nhi h
                return true;
            }
            //CASE -> 02  do nothing -> continue
            
         }
         return false; // cycle doesnt exist
    }
    public static void main(String[] args) {
        /*
               0 -------------3
              /|              |
             / |              |
            /  |              4
           1   |
           \   |
            \  |
             \ 2  
        */

            int V = 5; 
            ArrayList<Edge> graph[] = new ArrayList[V];
            createGraph(graph); //func call

            System.out.println(detectCycle(graph));
    }

}
