package com.spring.professional.exam.tutorial.module03.question05.util;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SqlRowSetUtil {
    private static final String EOL = System.lineSeparator();

    public static String SqlRowSetToString(SqlRowSet sqlRowSet) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SqlRowSet={").append(EOL);
        appendColumnNames(sqlRowSet, stringBuilder);
        appendRows(sqlRowSet, stringBuilder);
        stringBuilder.append("}").append(EOL);
        return stringBuilder.toString();
    }

    private static void appendColumnNames(SqlRowSet sqlRowSet, StringBuilder stringBuilder) {
        stringBuilder.append(String.join(",", sqlRowSet.getMetaData().getColumnNames()));
        stringBuilder.append(EOL);
    }

    private static void appendRows(SqlRowSet sqlRowSet, StringBuilder stringBuilder) {
        int columnCount = sqlRowSet.getMetaData().getColumnCount();

        while (sqlRowSet.next()) {
            String values = IntStream.range(1, columnCount + 1)
                    .mapToObj(sqlRowSet::getString)
                    .collect(Collectors.joining(","));

            stringBuilder.append(values).append(EOL);
        }
    }
}
