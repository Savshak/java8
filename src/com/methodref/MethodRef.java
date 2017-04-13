package com.methodref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodRef {

    public static void callMethodOfFooInterface(int a, Foo foo) {
        foo.method(a);
    }

    public static void main(String[] args) {
        // Reference to a static method
        callMethodOfFooInterface(300, MyClass::showAge);
        callMethodOfFooInterface(200, a -> MyClass.showAge(a));
        System.out.println("-------------------------------------");

        // Reference to an instance method of a particular object
        MyClass myClassObj = new MyClass();
        callMethodOfFooInterface(2, myClassObj::instanceMethod);
        callMethodOfFooInterface(2, a -> {
            MyClass myObj = new MyClass();
            myObj.instanceMethod(a);
        });
        System.out.println("-------------------------------------");

        // Reference to an instance method of an arbitrary object of a particular type
        Koo<MyClass> koo = (obj, a) -> obj.instanceMethod(a);
        koo.method(myClassObj, 4);
        Koo<MyClass> koo2 = MyClass::instanceMethod;
        koo2.method(myClassObj, 3);


        // second example
        String[] stringArray = {"Barbara", "James", "Mary", "John",
                "Patric", "Robert", "Michael", "linds", "Abram"};
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(stringArray));
        System.out.println("-------------------------------------");

        // Reference to a constructor
        MakeList makeList = ArrayList::new;
        List list = makeList.create();
    }

}

interface MakeList {
    List create();
}

interface Foo {
    void method(int a);
}

class MyClass {
    public static void showAge(int a) {
        System.out.println("age is: " + a);
    }

    public void instanceMethod(int a) {
        System.out.println(a * a + a);
    }
}

interface Koo<T> {
    void method(T t, int a);
}





