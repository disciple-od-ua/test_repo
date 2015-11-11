package com.company.newpackage;

/**
 * Created by apeshkov on 26.10.2015.
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("AAA");
        System.out.println(list.size());
        list.add("BBB");
        System.out.println(list.size());

        list.add("CCC");
        System.out.println(list.size());

        list.add("111");
        System.out.println(list.size());

        list.add("AAA");
        System.out.println(list.size());

        list.add("CCC");
        System.out.println(list.size());

        list.add(null);
        System.out.println(list.size());

        System.out.println(list);


        list.remove("AAA");
        System.out.println(list);
        System.out.println(list.size());

        list.remove(null);
        System.out.println(list);
        System.out.println(list.size());

        list.remove("CCC");
        System.out.println(list);
        System.out.println(list.size());
    }


    public static <T> SingleLinkedList<T> reverse(SingleLinkedList<T> linkedList)
    {
        return linkedList;
    }
}

class SingleLinkedList<T> {

    private Link<T> head;
    private Link<T> tail;
    private int size;

    public SingleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(T value) {
        if (size == 0) {
            head = new Link<>(value, null);
        } else if (tail == null) {
            tail = new Link<>(value, null);
            head.next = tail;
        } else {
            Link<T> newLink = new Link<>(value, null);
            tail.next = newLink;
            tail = newLink;
        }
        size++;
    }

    public T remove(T value) {
        Link<T> element = head;
        while (element != null) {
            if (element.value == value) {
                if (head == element && head.next == null) {
                    head = null;
                } else if (head == element && head.next != null) {
                    head = head.next;
                } else if (tail == element) {
                    tail = getPrevious(tail);
                    tail.next = null;
                } else {
                    getPrevious(element).next = element.next;
                }
                size--;
                return element.value;
            }
            element = element.next;
        }
        return null;
    }

    private Link<T> getPrevious(Link<T> link) {
        Link<T> element = head;
        while (element != null) {
            if (element.next == link) {
                return element;
            }
            element = element.next;
        }
        return null;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("[");
        Link<T> element = head;
        while (element != null) {
            b.append(element.value);
            b.append(",");
            element = element.next;
        }
        b.append("]");
        return b.toString();
    }

    private class Link<T> {
        T value;
        Link<T> next;

        public Link(T value, Link<T> next) {
            this.value = value;
            this.next = next;
        }
    }


}
