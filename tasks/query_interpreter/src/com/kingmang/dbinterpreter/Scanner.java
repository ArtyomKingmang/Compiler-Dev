package com.kingmang.dbinterpreter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Scanner {
    public static Stream<Row> read(String filename) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        List<String> schema = Arrays.asList(lines.removeFirst().split(","));
        return lines.stream().map(line -> new Row(Arrays.asList(line.split(",")), schema));
    }
}
