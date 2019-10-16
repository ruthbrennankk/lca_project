import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
class GraphTest {

    @Test
    public void testFindLCA() {
        //TODO
        //NUll Graph
        //No LCA
        //One not part of graph
        //Two not part of graph
        //Neither one or two in graph

        //one parent of two
        //two parent of one
        //one is lca but not parent
        //two is lca but not parent
        Graph graph = new Graph (6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,4);
        graph.addEdge(1,5);
        graph.addEdge(2,3);
        graph.addEdge(2,5);
        graph.addEdge(3,4);

        /*
              2 - 3 - 4
             / \     /
            0   \  /
             \ / \
              1 - 5
         */
        //Only 1 LCA

        //Two LCA

        //More than two LCA
    }

}