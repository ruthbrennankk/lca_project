
import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // return number of key-value pairs in BST
    public int size() { return size(root); }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) { return get(root, key); }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public String printKeysInOrder() {
        String toPrint = "(";
        if (!isEmpty())
            toPrint = print(root, toPrint);
        return toPrint + ")";
    }

    public String print(Node node, String string) {
        string += "(";
        if(node.left!=null) {
            string =  print(node.left, string);

        }
        string += ")";
        string += node.key;
        string += "(";
        if (node.right!=null) {
            string =  print(node.right, string);
        }
        string += ")";
        return string;

    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    public Node deleteMax(Node x) {
        if(x.right == null) {
            return x.left;
        } else {
            x.right = deleteMax(x.right);
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }
    }

    private Node max(Node x) {
        if (x==null) {
            return null;
        }
        if (x.right!=null) {
            return max(x.right);
        } else {
            return x;
        }
    }

    public Node delete(Node x, Key key) {
        if (x==null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp<0) x.left = delete(x.left, key);
        else if (cmp>0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = max(t.left);
            x.left = deleteMax(t.left);
            x.right = t.right;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Value findLCA(Value one, Value two) {
        Node tmp = LCA(root,one,two);
        if (tmp != null) {
            return tmp.val;
        }
        return null;
    }

    private Node LCA(Node node, Value one, Value two) {
        //TODO
        return null;
    }

}