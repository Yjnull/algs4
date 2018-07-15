package edu.princeton.cs.exercise.chapter3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Yangya on ${data}
 */

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int n;

        public Node(Key key, Value val, boolean color, int n) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.n = n;
        }
    }

    /*************************************************************************
     *  Node helper methods
     *************************************************************************/
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.n;
    }

    /*************************************************************************
     *  Size methods
     *************************************************************************/
    public int size() {return size(root);}

    public boolean isEmpty() {
        return root == null;
    }

    /*************************************************************************
     *  Standard BST search
     *************************************************************************/
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean contains(Node x, Key key) {
        return get(x, key) != null;
    }

    /*************************************************************************
     *  Red-black insertion
     *************************************************************************/

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null)
            return new Node(key, val, RED, 1);

        int cmp = key.compareTo(h.key);
        if      (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else              h.val = val;

        if (isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }

    /*************************************************************************
     *  Red-black deletion
     *************************************************************************/

    /*************************************************************************
     *  red-black tree helper functions
     *************************************************************************/
    private Node rotateLeft(Node h) {
        assert h != null && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        assert h != null && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        assert h != null && h.left != null && h.right != null;
        assert (!isRed(h) && isRed(h.left) && isRed(h.right))
                || (isRed(h) && !isRed(h.left) && !isRed(h.right));
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    /***********************************************************************
     *  Range count and range search.
     ***********************************************************************/
    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue<Key>();
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }


    /***********************************************************************
     *  Min, max, floor, and ceiling
     ***********************************************************************/
    public Key min() {
        if (isEmpty()) return null;
        return min(root).key;
    }

    private Node min(Node x) {
        assert x != null;
        if (x.left == null) return x;
        else                return min(x.left);
    }

    public Key max() {
        if (isEmpty()) return null;
        return max(root).key;
    }

    private Node max(Node x) {
        assert x != null;
        if (x.right == null) return x;
        else                 return max(x.right);
    }

    /*************************************************************************
     *  Check integrity of red-black BST data structure
     *************************************************************************/
    private boolean isRedBlackBST() {
        if (!isBST())            StdOut.println("Not in symmetric order");
        if (!is23())             StdOut.println("Not a 2-3 tree");
        if (!isBalanced())       StdOut.println("Not balanced");
        return isBST() && is23() && isBalanced();
    }

    private boolean is23() {
        return is23(root);
    }
    private boolean is23(Node x) {
        if (x == null) return true;
        if (isRed(x.right)) return false;
        if (x != root && isRed(x) && isRed(x.left))
            return false;
        return is23(x.left) && is23(x.right);
    }

    private boolean isBalanced() {
        int black = 0;
        Node x = root;
        while (x != null) {
            if (!isRed(x)) black++;
            x = x.left;
        }
        return isBalanced(root, black);
    }

    // does every path from the root to a leaf have the given number of black links?
    private boolean isBalanced(Node x, int black) {
        if (x == null) return black == 0;
        if (!isRed(x)) black--;
        return isBalanced(x.left, black) && isBalanced(x.right, black);
    }

    private boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }
}
