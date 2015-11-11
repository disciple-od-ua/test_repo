package com.company.newpackage;

/**
 * Created by apeshkov on 26.10.2015.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        /*Link<String> l3 = new Link<>("CCC", null);
        Link<String> l2 = new Link<>("BBB", l3);
        Link<String> l1 = new Link<>("AAA", l2);
        l1.print();
        //reverseRecursively(l1).print();
        reverseIteratively(l1).print();*/

        Link<String> l5 = new Link<>("EEE", null);
        Link<String> l4 = new Link<>("DDD", l5);
        Link<String> l3 = new Link<>("CCC", l4);
        Link<String> l2 = new Link<>("BBB", l3);
        Link<String> l1 = new Link<>("AAA", l2);
        System.out.println(hasCycle(l1));

        l3.setNext(l1);
        System.out.println(hasCycle(l1));

        l1.setNext(l1);
        System.out.println(hasCycle(l1));
    }

    public static <T> boolean hasCycle(Link<T> head) {
        Link<T> fast = head;
        Link<T> slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static <T> Link<T> reverseRecursively(Link<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        //get second node
        Link<T> second = head.getNext();
        //set first's next to be null
        head.setNext(null);

        Link<T> rest = reverseRecursively(second);
        second.setNext(head);

        return rest;
    }

    public static <T> Link<T> reverseIteratively(Link<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Link<T> first = head;
        Link<T> second = head.getNext();
        //set first's next to be null
        head.setNext(null);


        while (true) {
            Link<T> next = second.getNext();
            second.setNext(first);
            if (next != null) {
                first = second;
                second = next;
            } else {
                break;
            }
        }

        return second;
    }

}

class Link<T> {
    private T value;
    private Link<T> next;

    public Link(T value, Link<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public void print() {
        StringBuilder b = new StringBuilder();
        b.append("[");
        Link<T> link = this;
        while (link != null) {
            b.append(link.value);
            b.append(",");
            link = link.next;
        }
        b.append("]");
        System.out.println(b.toString());
    }
}
