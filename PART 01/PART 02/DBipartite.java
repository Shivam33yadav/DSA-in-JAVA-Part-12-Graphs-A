import java.util.*;
public class DBipartite {
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
         graph[0].add(new Edge(0, 2));

         graph[1].add(new Edge(1, 0));
         graph[1].add(new Edge(1, 3));

         graph[2].add(new Edge(2, 0));
         graph[2].add(new Edge(2, 4));

         graph[3].add(new Edge(3, 1));
         graph[3].add(new Edge(3, 4));

         graph[4].add(new Edge(4, 2));
         graph[4].add(new Edge(4, 3));


        }    
        public static boolean isBipartite(ArrayList<Edge>[] graph) { //O(V + E)
            int col[] = new int [graph.length];
            for(int i = 0; i<col.length; i++) {
                col[i] = -1; // initially koi colour nhi hoga  -> after making queue we update this blank arr

            }
            Queue<Integer> q = new LinkedList<>(); // we r performing BFS
             
                for(int i = 0; i<graph.length; i++) {
                    if(col[i]  == -1) { //perform BFS
                       q.add(i); //src node
                       col[i] = 0; // by default yellow is assign to src node
                       while(!q.isEmpty()) {
                        int curr = q.remove();
                        //checking for neighbours
                        for(int j = 0; j<graph[curr].size(); j++ ) {
                            Edge e = graph[curr].get(j); //e.dest
                           //CASE 01
                           if(col[e.dest] == -1) {
                              int nextCol = col[curr] == 0 ? 1 :0;
                              col[e.dest] = nextCol;
                              q.add(e.dest);

                           }//2nd case
                           else if(col[e.dest] == col[curr]) {
                            return false; //Non bipartite
                           }
                        }
                       }
                    }
                }
                return true;

        }
        
    public static void main(String[] args) {
        //if graph doesn't have cycle -> it is BIPARTITE GRAPH
        /*
                0 ------------ 2
               /              /
              /              /
             1              4
             \             /
                \         / 
                     3
        */

                     int V = 5;
                     ArrayList<Edge> graph[] = new ArrayList[V];
                     createGraph(graph);
                     System.out.println(isBipartite(graph));
    }
}
//ques -> find the length of the cycle if true
