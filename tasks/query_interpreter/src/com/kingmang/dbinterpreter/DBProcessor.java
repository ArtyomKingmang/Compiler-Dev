package com.kingmang.dbinterpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DBProcessor {

    public static List<String> selectFields(Row row, List<String> keys) {
        return keys.stream()
                .map(key -> row.fields.get(row.schema.indexOf(key)))
                .collect(Collectors.toList());
    }

    public static Stream<Row> Filter(Predicate<Row> pred, Stream<Row> parent) {
        return parent.filter(pred);
    }

    public static Predicate<Row> Eq(Function<Row, String> x, Function<Row, String> y) {
        return row -> x.apply(row).equals(y.apply(row));
    }

    public static Predicate<Row> Ne(Function<Row, String> x, Function<Row, String> y) {
        return row -> !x.apply(row).equals(y.apply(row));
    }

    public static Function<Row, String> Value(String x) {
        return row -> x;
    }

    public static Function<Row, String> Field(String x) {
        return row -> selectFields(row, Arrays.asList(x)).get(0);
    }

    public static Stream<Row> Project(List<String> newSchema, List<String> parentSchema, Stream<Row> parent) {
        return parent.map(row -> new Row(selectFields(row, parentSchema), newSchema));
    }

    public static Stream<Row> Join(Stream<Row> left, Stream<Row> right) {
        List<Row> rightList = right.toList();
        return left.flatMap(row1 -> rightList.stream()
                .filter(row2 -> {
                    List<String> keys = new ArrayList<>(new HashSet<>(row1.schema));
                    keys.retainAll(row2.schema);
                    return selectFields(row1, keys).equals(selectFields(row2, keys));
                })
                .map(row2 -> {
                    List<String> newFields = new ArrayList<>(row1.fields);
                    newFields.addAll(row2.fields);
                    List<String> newSchema = new ArrayList<>(row1.schema);
                    newSchema.addAll(row2.schema);
                    return new Row(newFields, newSchema);
                }));
    }


}
