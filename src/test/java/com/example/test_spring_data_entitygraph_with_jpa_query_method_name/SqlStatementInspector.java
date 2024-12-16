package com.example.test_spring_data_entitygraph_with_jpa_query_method_name;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.resource.jdbc.spi.StatementInspector;

public class SqlStatementInspector implements StatementInspector {

    public static final List<String> statements = Collections.synchronizedList(new ArrayList<>());

    @Override
    public String inspect(String sql) {
        statements.add(sql);
        return sql;
    }

}
