package com.company;

public class MyList {
    private final Entry header = new Entry();

    private int size = 0;

    public void add(Number item) {
        if (size == 0) {
            Entry newEntry = new Entry(item, null);
            header.next = newEntry;
            size++;
        } else {
            Entry entry = header;
            for (int i = 0; i <= size; i++) {
                if (entry.next == null || item.getDegree() > entry.next.element.getDegree()) {
                    Entry newEntry = new Entry(item, entry.next);
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

    public Number get(int i) {
        return entry(i).element;
    }

    public int size() {
        return size;
    }


    private Entry entry(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Entry entry = header;

        for (int i = 0; i <= index; i++) {
            entry = entry.next;
        }

        return entry;
    }

    private static class Entry {
        Number element;
        Entry next;

        Entry() {
        }

        Entry(Number element, Entry next) {
            this.element = element;
            this.next = next;
        }
    }

}
