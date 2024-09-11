package com.kingmang.dbinterpreter;

import java.util.stream.Stream;

public class DBConsole {

    public static void print(Stream<Row> parent) {
        parent.forEach(row -> System.out.println(String.join(" ", row.fields)));
    }
}
