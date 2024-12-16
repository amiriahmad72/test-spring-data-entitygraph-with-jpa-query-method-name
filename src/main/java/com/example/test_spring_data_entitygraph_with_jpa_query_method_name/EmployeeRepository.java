package com.example.test_spring_data_entitygraph_with_jpa_query_method_name;

import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @EntityGraph(attributePaths = "company")
    Set<Employee> findAllByCompanyEnableIsTrue();


    @EntityGraph(attributePaths = "company")
    @Query("""
            SELECT e
            FROM Employee e
            WHERE e.company.enable
            """)
    Set<Employee> findAllByCompanyEnableIsTrueUsingQuery();

}
