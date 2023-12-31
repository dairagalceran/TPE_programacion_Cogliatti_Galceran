
import java.util.NoSuchElementException;

public class UnionFind implements Cloneable{
    /**
     * parent[i] points to parent of element i or to self.
     */
    private int[] parent;

    /**
     * rank[i] holds the rank (cardinality) of root element i.
     */
    private int[] rank;

    /**
     * The number of disjoint sets
     */
    private int num;

    /**
     * Create n disjoint sets containing a single element numbered from 0 to n - 1.
     *
     * @param n
     */
    public UnionFind(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Expected n > 0");

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; ++i) {
            parent[i] = i; // root of self
            rank[i] = 1; // contains only self
        }
        num = n;
    }

    /**
     * Find representative element (i.e root of tree) for element i
     *
     * @param i
     * @return
     */
    public int find(int i) {
        if (i < 0 || i > parent.length)
            throw new NoSuchElementException("Invalid element");

        return this.root(i);
    }

    /**
     * Merge set containing u with the one containing u.
     *
     * @param u
     * @param v
     * @return the representative of union
     */
    public int union(int u, int v) {
        // Replace elements by representatives

        u = find(u);
        v = find(v);

        if (u == v)
            return u; // no-op

        // tomar una copia de estado antes de aplicar

        // Make smaller tree u point to v

        if (rank[v] < rank[u]) {
            int t = v;
            v = u;
            u = t; // swap u, v
        }

        parent[u] = v;
        rank[v] += rank[u];
        rank[u] = -1;

        num--;

        return v;
    }

    public int numberOfSets() {
        return num;
    }

    /**
     * Find representative (root) of element u
     */
    private int root(int u) {
        while (parent[u] != u)
            u = parent[u];
        return u;
    }

    /**
     * Get rank (i.e. cardinality) of the set containing element u
     *
     * @param u
     * @return
     */
    public int rank(int u) {
        u = root(u);
        return rank[u];
    }

    @Override
    public UnionFind clone() {
        try {
            UnionFind cloned = (UnionFind) super.clone();
            cloned.parent = parent.clone();
            cloned.rank = rank.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
