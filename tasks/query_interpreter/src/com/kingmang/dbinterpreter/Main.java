package com.kingmang.dbinterpreter;

import java.util.Arrays;

import static com.kingmang.dbinterpreter.DBProcessor.*;

public class Main {
    public static void main(String[] args) throws Exception {

        DBConsole.print(
                Project(Arrays.asList("room", "title"),
                        Arrays.asList("room", "title"),
                Filter(Eq(Field("time"), Value("09:00 AM")),
                        Scanner.read("talks.csv")))
        );


    }
}
