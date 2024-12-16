package com.example.test_spring_data_entitygraph_with_jpa_query_method_name;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    void beforeEach() {
        SqlStatementInspector.statements.clear();
    }

    @Test
    void testQueryMethodName() {
        employeeRepository.findAllByCompanyEnableIsTrue();
        String sqlStatement = SqlStatementInspector.statements.get(0);
        Pattern pattern = Pattern.compile("join company");
        assertEquals(1, pattern.matcher(sqlStatement).results().count());
    }

    @Test
    void testQuery() {
        employeeRepository.findAllByCompanyEnableIsTrueUsingQuery();
        String sqlStatement = SqlStatementInspector.statements.get(0);
        Pattern pattern = Pattern.compile("join company");
        assertEquals(1, pattern.matcher(sqlStatement).results().count());
    }

}
