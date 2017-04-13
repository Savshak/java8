package com.defaultandstatic;

public class DefaultAndStatic {
    public static void main(String[] args) {

    }
}

class FooImpl implements Foo, Boo {
    public void defaultMethod() {
        Foo.super.defaultMethod();
    }
}


interface Foo {
    default void defaultMethod() {
        System.out.println("Hello I'm form default method of Foo interface.");
    }

    static void staticMethod() {
        System.out.println("Hello I'm form static method of Foo interface.");
    }
}

interface Boo {
    default void defaultMethod() {
        System.out.println("Hello I'm from default of Boo");
    }
}
