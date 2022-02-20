package com.spring.professional.exam.tutorial.module03.question05.dao;

import com.spring.professional.exam.tutorial.module03.question05.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> findEmployees() {
        return jdbcTemplate.query(
                "select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee",
                this::mapEmployee
        );
    }

    public List<String> findEmployeesEmails() {
        return jdbcTemplate.queryForList("select email from employee", String.class);
    }

    public Employee findEmployeeWithHighestSalary() {
        return jdbcTemplate.queryForObject(
                "select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee order by salary desc limit 1",
                this::mapEmployee
        );
    }

    public Employee findEmployeeById(Integer id) {
        return jdbcTemplate.queryForObject(
                "select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee where employee_id = ?",
                new Object[]{id},
                this::mapEmployee
        );
    }

    public Map<String, Object> findEmployeeThatWasHiredLast() {
        return jdbcTemplate.queryForMap(
                "select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee order by hire_date limit 1"
        );
    }

    public SqlRowSet findEmployeesEmailsAndPhones() {
        return jdbcTemplate.queryForRowSet(
                "select email, phone_number from employee"
        );
    }

    public void insertNewDummyRecord() {
        jdbcTemplate.execute(
                "insert into employee values(999, 'Dummy', 'Dummy', 'Dummy.Dummy@dummy.com', '111-11-11', '2019-06-05', 1)"
        );
    }

    public int updateDummyRecord(Integer id, String firstName) {
        return jdbcTemplate.update(
                "update employee set first_name = ? where employee_id = ?",
                new Object[]{firstName, id}
        );
    }

    public int[] updateRecordsWithDummyData() {
        return jdbcTemplate.batchUpdate(
                "update employee set first_name = 'AAA' where employee_id = 1",
                "update employee set first_name = 'BBB' where employee_id = 2",
                "update employee set first_name = 'CCC' where employee_id = 3"
        );
    }

    @SneakyThrows
    private Employee mapEmployee(ResultSet resultSet, int i) {
        return new Employee(
                resultSet.getInt("employee_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getDate("hire_date"),
                resultSet.getFloat("salary")
        );
    }
}
