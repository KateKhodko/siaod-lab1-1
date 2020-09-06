package com.company;

public class MyList {
    private final Node header = new Node();

    private int size = 0;


    /*
    public void add(Number item) {
        if (size == 0) {
            Node newEntry = new Node(item, null);
            header.next = newEntry;
            size++;
        } else {
            Node entry = header;
            for (int i = 0; i <= size; i++) {
                if (entry.next == null || item.getDegree() > entry.next.element.getDegree()) {
                    Node newEntry = new Node(item, entry.next);
                    entry.next = newEntry;
                    size++;
                    break;
                } else if (item.getDegree() < entry.next.element.getDegree()) {
                    entry = entry.next;
                } else {
                    double sum = entry.next.element.getNum() + item.getNum();
                    entry.next.element = new Number(entry.next.element.getDegree(), sum);
                    break;
                }
            }
        }
    }

     */


    public void add(Number item) {
        Node node = new Node(item, null);
        if (header.next != null) {
            Node last = entry(size-1);
            last.next = node;
        } else {
            header.next = node;
        }
        size++;
    }

    public void remove(int index) {
        Node node = entry(index);
        if (node.next != null) {
            node.element = node.next.element;
            node.next = node.next.next;
        } else {
            node.element  = null;
            node.next = null;
        }
        size--;
    }

    public Number get(int i) {
        return entry(i).element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node entry(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Node node = header;

        for (int i = 0; i <= index; i++) {
            node = node.next;
        }

        return node;
    }

    private static class Node {
        Number element;
        Node next;

        Node() {
        }

        Node(Number element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

}
