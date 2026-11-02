import java.util.*;
public class GTopologicalSortUsingBFS {  // topological sort BFS is easy
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
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    //helper function -> calculates in-degree
    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) { // for indegree destination should be +1
       for(int i =0; i<graph.length; i++) {
        int v = i; //vertex = i
        for(int j = 0; j<graph[v].size(); j++) {
            Edge e = graph[v].get(j);
            indeg[e.dest]++;
        }
       }
    } 
    public static void topSort(ArrayList<Edge> graph[]) {
        //calculate in-degree for all nodes
      int indeg[] =   new int[graph.length];
      calcIndeg(graph, indeg);
      Queue<Integer> q = new LinkedList<>();

      // jinki indegree 0 k equal h unko queue m add krna h 
      for(int i = 0; i<indeg.length; i++) {
        if(indeg[i] == 0) {
            q.add(i); //vertex ko add in queue
        }
      }
      //BFS
      while (!q.isEmpty()) { //jb tak queu khali nhi tab tak traverse krna 
         int curr = q.remove();  // har baar q se ek elem nikalna h aur is element ko topological sort m add or print
         System.out.println(curr+" ");

         for(int i =0; i<graph[curr].size(); i++) { //curr k sare neighbours k liye -1
            Edge e = graph[curr].get(i);
            indeg[e.dest]--;//indeg -- hone pr agr 0 ho jati h tabhi q m add krenge
            if(indeg[e.dest] == 0) {
                q.add(e.dest);
            }
         }
      }
      System.out.println();
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topSort(graph);
    }
}
