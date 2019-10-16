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

    public int[] findLCA(int one, int two) {
        //TODO
        // Reverse adj list to a parent list
        // TODO work out depth for all ancestors for one
        // TODO work out depth for lal ancestors for two
        // TODO calculate total depth
            //note themselves = 0 (stored as -1)
            //any 0 store -1 (not ancestor)
        return null;
    }


} 