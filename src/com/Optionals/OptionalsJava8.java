package com.Optionals;

import java.util.Optional;

public class OptionalsJava8 {
    // A container object which may or may not contain a non-null value
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");
        System.out.println(optional.isPresent());
        System.out.println(optional.get());
        System.out.println(optional.orElse("fallback"));
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }
}
