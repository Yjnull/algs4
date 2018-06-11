package edu.princeton.cs.exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item>{

    private Node first;      // beginning of queue
    private Node last;       // end of queue
    private int N;           // size
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null;}

    public int size() {return N;}

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) throw  new RuntimeException("Queue underflow");
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
        }
    }

    public static void main(String[] args) {
        Queue<String> s = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!"-".equals(item))
                s.enqueue(item);
            else if (!s.isEmpty())
                StdOut.print(s.dequeue() + " ");
        }
        StdOut.println("(" + s.size() + " left on queue)");
    }
}
