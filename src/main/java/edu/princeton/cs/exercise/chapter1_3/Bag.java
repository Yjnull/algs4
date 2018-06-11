package edu.princeton.cs.exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Bag<Item> implements Iterable<Item>{

    private Node first;      // top of stack
    private int N;           // size
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null;}

    public int size() {return N;}

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
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
        Bag<String> s = new Bag<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!"-".equals(item))
                s.add(item);
        }
        Iterator iterator = s.iterator();
        while (iterator.hasNext())
            StdOut.println(iterator.next() + " ");
        StdOut.println("(" + s.size() + " left on bag)");

    }
}
