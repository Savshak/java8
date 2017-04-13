package com.lampda;

public class Lampda {
    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public void method() {
                System.out.println("Hello I'm from anonymous inner class method()");
            }
        };

        callMethodOfFooInterface(foo);
        callMethodOfFooInterface(new Foo() {
            @Override
            public void method() {
                System.out.println("Hello I'm from anonymous class created just before passing as argument");
            }
        });
        callMethodOfFooInterface(() -> System.out.println("Hello I'm from lampda"));
    }

    public static void callMethodOfFooInterface(Foo foo) {
        foo.method();
    }
}

@FunctionalInterface
interface Foo {
    void method();
}

/*
 * your needn't to indicate param data type. compiler will infer it.
 * () -> without {} and return if only one statement
 * a -> without () if only one argument
 *
 */