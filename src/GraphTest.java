import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
class GraphTest {

    @Test
    public void testFindLCA() {
        Graph graph = new Graph(0);
        assertNull("Checking with empty Graph",graph.findLCA(1,2));
        graph = new Graph(4);
        graph.addEdge(1,3);
        graph.addEdge(1,2);
        /*
               3
             /
            1
              \
                2
         */
        assertNull("Checking one not in graph", graph.findLCA(4,1));
        assertNull("Checking two not in graph", graph.findLCA(1,4));
        assertNull("Neither one or two in graph", graph.findLCA(5,4));

        int[] tester = new int[]{1};
        assertEquals("one parent of two",tester, graph.findLCA(1,2));
        assertEquals("two parent of one",tester, graph.findLCA(2,1));

        graph.addEdge(2,4);
         /*
               3
             /
            1
              \
                2
                  \
                    4
         */
        assertEquals("one is lca but not parent",tester, graph.findLCA(1,4));
        assertEquals("two is lca but not parent",tester, graph.findLCA(4,1));

        graph = new Graph (6);
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
        tester = new int[]{1,2};
        assertEquals("Two LCA",tester, graph.findLCA(4,5));
        //More than two LCA
    }

}