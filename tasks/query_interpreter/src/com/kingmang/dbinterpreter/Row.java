package com.kingmang.dbinterpreter;

import java.util.List;

public final class Row {
    List<String> fields;
    List<String> schema;

    Row(List<String> fields, List<String> schema) {
        this.fields = fields;
        this.schema = schema;
    }
}