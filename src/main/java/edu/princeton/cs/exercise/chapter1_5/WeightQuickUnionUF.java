package edu.princeton.cs.exercise.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightQuickUnionUF {

    private int[] id;     // 分量id (以触点作为索引)
    private int[] sz;     // (由触点索引的)各个根节点所对应的分量的大小
    private int count;    // 分量数量

    public WeightQuickUnionUF(int N)
    {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count()
    { return  count; }

    public boolean connected(int p, int q)
    { return find(p) == find(q); }

    public int find(int p)
    {
        while (p != id[p])
        {
            id[p] = id[id[p]];    //路径压缩
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[i] += sz[j]; }

        count--;
    }

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        WeightQuickUnionUF uf = new WeightQuickUnionUF(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " --- " + q);
        }

        StdOut.println(uf.count() + " components");
    }
}
