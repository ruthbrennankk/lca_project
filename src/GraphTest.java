import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GraphTest {

    @Test
    public void testFindLCA() {
        Graph graph = new Graph(0);
        assertNull("Checking with empty Graph",graph.findLCA(1,2));
        graph = new Graph(4);
        graph.addEdge(0,2);
        graph.addEdge(0,1);
        /*
               2
             /
            0
              \
                1
         */
        assertNull("Checking one not in graph", graph.findLCA(4,1));
        assertNull("Checking two not in graph", graph.findLCA(1,4));
        assertNull("Neither one or two in graph", graph.findLCA(5,4));

        int[] tester = new int[]{0};
        int[] temp = null;

/*

        //assertEquals("one parent of two",tester, graph.findLCA(1,2));
        temp = graph.findLCA(0,2);
        assertEquals("one parent of two - length",tester.length, temp.length);
        assertEquals("one parent of two",tester[0], temp[0]);

        //assertEquals("two parent of one",tester, graph.findLCA(2,1));
        temp = graph.findLCA(2,0);
        assertEquals("two parent of one - length",tester.length, temp.length);
        assertEquals("two parent of one",tester[0], temp[0]);

        graph.addEdge(1,3);
        /*
               2
             /
            0
              \
                1
                  \
                    3


        //assertEquals("one is lca but not parent",tester, graph.findLCA(0,3));
        temp = graph.findLCA(0,3);
        assertEquals("one is lca but not parent - length",tester.length, temp.length);
        assertEquals("one is lca but not parent",tester[0], temp[0]);

        //assertEquals("two is lca but not parent",tester, graph.findLCA(3,0));
        temp = graph.findLCA(3,0);
        assertEquals("two is lca but not parent - length",tester.length, temp.length);
        assertEquals("two is lca but not parent",tester[0], temp[0]);
*/
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

        tester = new int[]{1};
        //assertEquals("one lca",tester, graph.findLCA(4,5));
        temp = graph.findLCA(4,5);
        assertEquals("two parent of one - length",tester.length, temp.length);
        assertEquals("two parent of one",tester[0], temp[0]);

        //two LCAs
        graph = new Graph (6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,4);

        /*
              2 ----- 3
             / \     /
            0   \  /
             \ / \
              1 - 4
        */
        tester = new int[]{1,2};
        //assertEquals("Two LCA",tester, graph.findLCA(3,4));
        temp = graph.findLCA(3,4);
        assertEquals("Two LCA - length",tester.length, temp.length);
        assertEquals("Two LCA",tester[0], temp[0]);
        assertEquals("Two LCA",tester[1], temp[1]);

        //More than two LCA
        graph.addEdge(1,5);
        graph.addEdge(5,3);
        graph.addEdge(5,4);
        tester = new int[]{1,2,5};
        //assertEquals("Two LCA",tester, graph.findLCA(3,4));
        temp = graph.findLCA(3,4);
        assertEquals("More than two LCA",tester.length, temp.length);
        assertEquals("More than two LCA",tester[0], temp[0]);
        assertEquals("tMore than two LCA",tester[1], temp[1]);
        assertEquals("tMore than two LCA",tester[2], temp[2]);

    }

}