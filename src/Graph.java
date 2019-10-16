import java.io.*;
import java.util.*;

public class Graph
{
    private int V;
    private LinkedList<AdjListNode>adj[];
    Graph(int v)
    {
        V=v;
        adj = new LinkedList[V];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<AdjListNode>();
    }
    void addEdge(int u, int v, int weight)
    {
        AdjListNode node = new AdjListNode(v,weight);
        adj[u].add(node);// Add v to u's list
    }

    // A recursive function used by shortestPath.
    //    // See below link for details
    void topologicalSortUtil(int v, Boolean visited[], Stack stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<AdjListNode> it = adj[v].iterator();
        while (it.hasNext())
        {
            AdjListNode node =it.next();
            if (!visited[node.getV()])
                topologicalSortUtil(node.getV(), visited, stack);
        }
        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }
}

class AdjListNode
{
    private int v;
    private int weight;
    AdjListNode(int _v, int _w) { v = _v;  weight = _w; }
    int getV() { return v; }
    int getWeight()  { return weight; }
}
