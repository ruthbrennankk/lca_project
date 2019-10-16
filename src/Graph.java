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

    private int[] depths (int a, List<Integer> parentListArray[]) {
        int[] depths = new int[V];
        for (int i = 0; i < V; i++) {
            if ( i == a ) {
                depths[i] = -1;
            } else {
                depths[i] = 0;
            }
        }

        depths = depths_rec(a,depths,parentListArray,1);

        return depths;
    }

    private int[] depths_rec(int a, int[] depths, List<Integer> parentListArray[], int depth) {
        Iterator<Integer> list = parentListArray[a].listIterator();
        while (list.hasNext())
        {
            int n = list.next();
            if (depths[n]>depth || depths[n]==0) {
                depths[n] = depth;
            }
            if (!parentListArray[n].isEmpty()) {
                depths = depths_rec(n,depths,parentListArray,depth+1);
            }
        }
        return depths;
    }

    public int[] findLCA(int x, int y) {
        if (x<V && y<V) {
            // Reverse adj list to a parent list
            List<Integer> parentListArray[] = new LinkedList[V];
            //initalise to zero
            for (int i = 0; i < V; i++) {
                parentListArray[i] = new LinkedList<>();
            }
            //loop through to reverse
            for (int i=0; i<V; i++) {

                Iterator<Integer> list = adjListArray[i].listIterator();
                while (list.hasNext())
                {
                    int n = list.next();
                    parentListArray[n].add(i);

                }
            }

            // work out depth for all ancestors for x
            int[] x_depths = depths(x, parentListArray);

            //print out
            System.out.println("x depths");
            for (int i=0; i<V; i++) {
                System.out.println(i + " = " + x_depths[i]);
            }

            // work out depth for lal ancestors for y
            int[] y_depths = depths(y, parentListArray);
            //print out
            System.out.println("y depths");
            for (int i=0; i<V; i++) {
                System.out.println(i + " = " + y_depths[i]);
            }

            // calculate total depth use that to find lacs
            int lcas[] = getLcas(x_depths,y_depths);
            //print out
            System.out.println("LCAs");
            for (int i=0; i<lcas.length; i++) {
                System.out.println(i + " = " + lcas[i]);
            }

            return lcas;
        }
        return null;

    }

    int[] getLcas (int[] x_depths, int[] y_depths) {
        //note themselves = 0 (stored as -1)
        //any 0 store -1 (not ancestor)
        int[] total_depths = new int[V];
        int lca_depth = V+1;
        int[] lcas = null;

        for (int i = 0; i < V; i++) {
            //work out total depth
            if (x_depths[i] == 0 || y_depths[i] == 0) {
                total_depths[i] = -1;
            } else if (x_depths[i] == -1) {
                total_depths[i] = y_depths[i];
            } else if (y_depths[i] == -1) {
                total_depths[i] = x_depths[i];
            } else {
                total_depths[i] = x_depths[i] + y_depths[i];
            }

            //organise LCAS into array and for return
            if (total_depths[i] < lca_depth && total_depths[i] != -1) {
                lcas = new int[1];
                lcas[0] = i;
                lca_depth = total_depths[i];
            } else if (total_depths[i] == lca_depth) {
                lcas = Arrays.copyOf(lcas, lcas.length + 1);
                lcas[lcas.length - 1] = i;
            }
        }
        System.out.println("total depths");
        for (int i=0; i<total_depths.length; i++) {
            System.out.println(i + " = " + total_depths[i]);
        }

        return lcas;
    }



} 