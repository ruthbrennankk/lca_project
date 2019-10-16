import java.util.*;

class Graph {
    int V; // No. of vertices 

    List<Integer> adjListArray[];

    public Graph(int V) {

        this.V = V;

        @SuppressWarnings("unchecked")
        List<Integer> adjListArray[] = new LinkedList[V];

        this.adjListArray = adjListArray;

        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {

        this.adjListArray[src].add(dest);

    }

    public void findLCA() {
        //TODO

    }


} 