package com.company.newpackage;

import java.io.IOException;

/**
 * Created by apeshkov on 26.10.2015.
 */
public class InheritanceTest {

    public static void main(String[] args) {
        A a1 = new A();
        B b = new B();
        A a2 = new B();

        a1.method2();
        b.method2();
        a2.method2();
    }
}

class A {
    private Number method(Integer a) throws Exception {
        return new Integer(1);
    }

    public static void method2() {
        System.out.println("A");
    }
}

class B extends A {
    public Integer method(Integer a) throws IOException {
        return new Integer(2);
    }

    public static void method2() {
        System.out.println("B");
    }
}



