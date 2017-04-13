package com.java8functionalinterfaces;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class NativeInterfaces {
    // Predicates Represents a predicate (boolean-valued function) of one argument.     Boolean test(T t)
    // Functions Represents a function that accepts one argument and produces a result  R apply(T t)
    // Suppliers Represents a supplier of results.                                      T get()
    // Consumers Represents an operation that accepts a single input argument           void accept(T t)
    // Comparators

    public static void main(String[] args) {
        // Predicates
        Predicate<ClassA> isNull = Objects::isNull;
        ClassA aObj = null;
        System.out.println(isNull.test(aObj));
        System.out.println("----------------------");

        Function<Integer, String> toString = String::valueOf;
        System.out.println(toString.apply(10));
        System.out.println("------------------------");

        Supplier<String> supplier = () -> "hello";
        System.out.println(supplier.get());
        System.out.println("------------------------");


        Consumer<String> consumer = (a) -> System.out.println(a);
        consumer.accept("Hello from Consumer interface method accept");
        System.out.println("------------------------");


    }
}

class ClassA {

}
