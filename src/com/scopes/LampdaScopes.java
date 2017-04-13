package com.scopes;

public class LampdaScopes {

    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Foo foo = a -> {
            outerNum = 10;
            outerStaticNum = 100;
            System.out.println(a);
        };
        foo.method(13);
    }

    public static void main(String[] args) {
        // accessing local variables. local variable must be final. or final at compile time
        int i = 10;
        Foo foo = a -> System.out.println(a + i);
        foo.method(10);
        System.out.println("------------------------------");

        // Accessing fields and static variables
        // In contrast to local variables, we have both read and write
        // access to instance fields and static variables from within lambda expressions.
        LampdaScopes l = new LampdaScopes();
        l.testScopes();
        System.out.println(l.outerNum);
        System.out.println(LampdaScopes.outerStaticNum);
        System.out.println("-----------------------------");

        // Default methods cannot be accessed from within lambda expressions
        // Foo foo2 = a -> System.out.println(sqrt(a));
        // but
        Foo foo2 = new Foo() {
            @Override
            public void method(int a) {
                System.out.println(sqrt(a));
            }
        };
        foo2.method(16);
        System.out.println("-------------------------------");
    }
}

interface Foo {
    void method(int a);

    default double sqrt(double a) {
        return Math.sqrt(a);
    }
}


