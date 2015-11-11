package com.company.newpackage;


public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        list.add("DDD");
        list.add("EEE");
        list.add("FFF");
        list.add(null);
        System.out.println(list);
        System.out.println(list.size());

        list.remove("AAA");
        System.out.println(list);
        System.out.println(list.size());

        list.remove("FFF");
        System.out.println(list);
        System.out.println(list.size());

        list.remove("DDD");
        System.out.println(list);
        System.out.println(list.size());

        list.remove("BBB");
        System.out.println(list);
        System.out.println(list.size());

        list.remove("CCC");
        System.out.println(list);
        System.out.println(list.size());

        list.remove("EEE");
        System.out.println(list);
        System.out.println(list.size());

        list.add("111");
        System.out.println(list);
        System.out.println(list.size());

        list.add("333");
        System.out.println(list);
        System.out.println(list.size());

        list.remove("EEE");
        System.out.println(list);
        System.out.println(list.size());
    }
}

class LinkedList<T>  {

    private Link<T> head;
    private Link<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Link<T> element = head;
        boolean first = true;
        while (element != null) {
            if (!first) {
                builder.append(",");
            }
            first = false;
            builder.append(element.value);
            element = element.next;
        }
        builder.append("]");
        return builder.toString();
    }

    public void add(T element) {
        if (isEmpty()) {
            head = new Link<T>(element, null, null);
        } else if (tail == null) {
            Link<T> newLink = new Link<T>(element, null, head);
            head.next = newLink;
            tail = newLink;
        } else {
            Link<T> newLink = new Link<T>(element, null, tail);
            tail.next = newLink;
            tail = newLink;
        }
        size++;
    }

    public T remove(T element) {
        if (isEmpty()) {
            return null;
        } else {
            Link<T> el = head;
            while (el != null) {
                if (el.value != null && el.value.equals(element)) {
                    if (el == head && head.next == null) {
                        head = null;
                    } else if (el == head && head.next != null) {
                        head.next.prev = null;
                        head = head.next;
                    } else if (el == tail && tail.prev != head) {
                        tail.prev.next = null;
                        tail = tail.prev;
                    } else if (el == tail && tail.prev == head) {
                        tail.prev.next = null;
                        tail = null;
                    } else {
                        el.prev.next = el.next;
                        el.next.prev = el.prev;
                    }
                    size--;
                    return el.value;
                }
                el = el.next;
            }
            return null;
        }
    }

    private class Link<T> {
        private T value;
        private Link<T> next;
        private Link<T> prev;

        public Link(T value, Link<T> next, Link<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
