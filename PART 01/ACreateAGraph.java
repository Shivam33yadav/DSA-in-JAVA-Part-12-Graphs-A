
import java.util.*;
public class ACreateAGraph{
    //to create a graph we need class of info of edges 
      static class Edge{ //src , des, weight
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }       
      }
    public static void main(String[] args) {
        /*
                    (5)
              0 ---------- 1
                        /    \
                    (1)/     \ (3)
                      /       \
                     2  ----- 3 
                     |    (1)
                (2)  |  
                     |
                     4

            */         
                    // 0 to 4 are vertices so total = 5;
            int V = 5; //jitni vertices h utni hi size ka ek arr create krna hota hh
            ArrayList<Edge>[] graph = new ArrayList[V];  // null means arr m koi arrList nhi h  -> empty arraylist
            
            for(int i =0; i<V; i++) {
                graph[i] = new ArrayList<>(); // har idx pr jake make new arraylist
            }

            //0 -vertex
            graph[0].add(new Edge(0,1,5));  //for 0 vertex

            //1 vertex k liye 3 edges h 
            graph[1].add(new Edge(1, 0, 5)); //edge 1
             graph[1].add(new Edge(1, 2, 1));  //e2
              graph[1].add(new Edge(1, 3, 3));  //e3

              //2 vertex
               graph[2].add(new Edge(2, 1, 1)); //e1
               graph[2].add(new Edge(2, 3, 1));  //e2
               graph[2].add(new Edge(2, 4, 4));  //e3

               //3 vertex
               graph[3].add(new Edge(3, 1, 3)); // e1
               graph[3].add(new Edge(3, 2, 1)); // e2

               //4 vertex
               graph[4].add (new Edge(4, 2, 2));// e1

               //for storing neighbours
             //2's neighbour
             for(int i =0; i<graph[2].size(); i++)  {
                Edge e = graph[2].get(i); //edge ka src, des, wt hoga
                System.out.println(e.dest);
             } 

    }
       }
    
    
