package edu.princeton.cs.exercise.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class List<Item> implements Iterable<Item> {

    private int N;
    private Node first;
    private Node last;

    private class Node
    {
        private Item item;
        private Node next;
    }

    public List()
    {
        this.first = null;
        this.last = null;
    }

    public List(Item[] a)
    {
        for (Item t : a)
            append(t);
    }

    public List(Iterable<Item> coll)
    {
        for (Item t : coll)
            append(t);
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return N;
    }

    public Item first()
    {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return first.item;
    }

    public Item last()
    {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return last.item;
    }

    public Item removeFirst()
    {
        if (isEmpty()) throw new RuntimeException("List is empty");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }

    public void prepend(Item item)
    {
        Node x = new Node();
        x.item = item;
        if (isEmpty()) { first = x;           last = x;}
        else           { x.next = first.next; first = x;}
        N++;
    }

    public void append(Item item)
    {
        Node x = new Node();
        x.item = item;
        if (isEmpty()) { first = x;     last = x;}
        else           { last.next = x; last = x;}
        N++;
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item).append(" ");
        return s.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;


        @Override
        public boolean hasNext() { return current != null; }

        @Override
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() { throw new UnsupportedOperationException(); }
    }

    /*****************
     * Exercise 1.3.19
     *****************/
    public Item removeLast()
    {
        if (isEmpty()) throw new RuntimeException("List is empty");
        if (first == last) return removeFirst();
        Item item = last.item;

        Node prev = null, curr = first;
        while (curr.next != null)
        {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        last = prev;
        N--;

        return item;
    }

    /*****************
     * Exercise 1.3.20
     *****************/
    public Item delete(int k)
    {
        if (k < 1) return null;

        int i = 1;
        Node prev = null, curr = first;
        while (i < k && curr != null)
        {
            prev = curr;
            curr = curr.next;
            i++;
        }

        if (curr != null)
        {
            if (prev == null)
                first = curr.next;
            else prev.next = curr.next;

            if (curr.next == null)
                last = prev;

            N--;
            return curr.item;
        }
        else
            return null;
    }

    /*************************************
     * Exercise 1.3.21
     * (Renamed from find() to contains())
     *************************************/
    public boolean contains(Item item)
    {
        Node curr = first;
        while (curr != null && !curr.item.equals(item))
            curr = curr.next;
        return curr != null;
    }

    /*************************************
     * Exercise 1.3.24
     *************************************/
    public void removeAfter(Node node)
    {
        if (node != null && node.next != null)
        {
            if (node.next.next == null)
                last = node;
            node.next = node.next.next;
            N--;
        }
    }

    /*************************************
     * Exercise 1.3.25
     *************************************/
    public void insertAfter(Node a, Node b)
    {
        if (a != null && b != null)
        {
            if (last == a)
                last = b;
            b.next = a.next;
            a.next = b;
            N++;
        }
    }

    /*************************************
     * Exercise 1.3.26
     *************************************/
    public void remove(Item item)
    {
        List<Integer> idx = new List<>();
        int i = 1;

        for (Item x : this)
        {
            if (x.equals(item))
                idx.prepend(i);
            i++;
        }

        for (int k : idx)
            delete(k);
    }

    /*************************************
     * Exercise 1.3.27
     * Type 'Item' must implement interface Comparable
     *************************************/
    public Item max(Node node)
    {
        if (node == null)
            return null;

        Item max = node.item;
        Node curr = node;

        while (curr.next != null)
        {
            curr = curr.next;
            if (((Comparable)max).compareTo(curr.item) < 0)
                max = curr.item;
        }

        return max;
    }

    /*************************************************
     * Exercise 1.3.28
     * (recursive variant of Exercise 1.3.27)
     * Type 'Item' must implement interface Comparable
     *************************************************/
    public Item maxRec(Node node)
    {
        if (node == null) return null;

        if (node.next == null)
            return node.item;
        else
        {
            Item maxTail = maxRec(node.next);
            return ((Comparable)node.item).compareTo(maxTail) > 0 ? node.item : maxTail;
        }
    }

    /*************************************************
     * Exercise 1.3.30
     *************************************************/
    public Node reverse(Node x)
    {
        Node first = x;
        Node reverse = null;
        while (first != null)
        {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public Node reverseRec(Node first)
    {
        if (first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = reverseRec(second);
        second.next = first;
        first.next = null;
        return rest;
    }

    public static void main(String[] args)
    {
        List<Integer> mList = new List<>(new Integer[]{1, 2, 3});
        mList.delete(3);
        StdOut.println(mList);
    }
}
