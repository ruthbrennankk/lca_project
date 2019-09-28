import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BSTTest
{

    //TODO write more tests here.
    @Test
    public void testGet() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        assertEquals("Checking in get on an empty tree", null, bst.get(7));

        bst.put(7, 7);   //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \
        bst.put(2, 2);   // 1       6
        bst.put(6, 6);   //  \     /
        bst.put(4, 4);   //   2   4
        bst.put(5, 5);	 //        \
        //         5

        assertEquals("Getting the root", "7", bst.get(7).toString());
        assertEquals("Getting a leaf", "2", bst.get(2).toString());
        assertEquals("Getting root of a sub-tree", "3", bst.get(3).toString());
    }

    @Test
    public void testPrintInOrder() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        assertEquals("Checking in order printing of empty tree","()", bst.printKeysInOrder());

        //	 2
        //	/ \
        //   1   3
        //        \
        //           4

        bst.put(2, 7);
        bst.put(1, 9);
        bst.put(3, 7);
        bst.put(4, 9);

        //output: "((()A())B(()C(()D())))"

        String result = "((()1())2(()3(()4())))";
        assertEquals("Checking in order printing of non-empty tree", result, bst.printKeysInOrder());
    }

    /** <p>Test {@link BST#delete(Comparable)}.</p> */
    @Test
    public void testDelete() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        bst.delete(1);
        assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());

        bst.put(7, 7);   //        _7_
        bst.put(8, 8);   //      /     \
        bst.put(3, 3);   //    _3_      8
        bst.put(1, 1);   //  /     \
        bst.put(2, 2);   // 1       6
        bst.put(6, 6);   //  \     /
        bst.put(4, 4);   //   2   4
        bst.put(5, 5);   //        \
        //         5

        assertEquals("Checking order of constructed tree",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

        bst.delete(9);
        assertEquals("Deleting non-existent key",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());

        bst.delete(8);
        assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());

        bst.delete(6);
        assertEquals("Deleting node with single child",
                "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());

        bst.delete(3);
        assertEquals("Deleting node with two children",
                "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
    }

}
