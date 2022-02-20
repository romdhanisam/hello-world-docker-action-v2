package com.spring.professional.exam.tutorial.module03.question05.service;

import com.spring.professional.exam.tutorial.module03.question05.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static com.spring.professional.exam.tutorial.module03.question05.util.SqlRowSetUtil.SqlRowSetToString;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println("Employee Report Start");

        System.out.println("findEmployees()");
        employeeDao.findEmployees()
                .forEach(System.out::println);

        System.out.println("findEmployeesEmails()");
        employeeDao.findEmployeesEmails()
                .forEach(System.out::println);

        System.out.println("findEmployeeWithHighestSalary()");
        System.out.println(employeeDao.findEmployeeWithHighestSalary());

        System.out.println("findEmployeeThatWasHiredLast()");
        System.out.println(employeeDao.findEmployeeThatWasHiredLast());

        System.out.println("findEmployeesEmailsAndPhones()");
        System.out.println(SqlRowSetToString(employeeDao.findEmployeesEmailsAndPhones()));

        System.out.println("insertNewDummyRecord()");
        employeeDao.insertNewDummyRecord();
        System.out.println(employeeDao.findEmployeeById(999));

        System.out.println("updateDummyRecord()");
        System.out.println("Result from update = " + employeeDao.updateDummyRecord(999, "UpdatedDummy"));
        System.out.println(employeeDao.findEmployeeById(999));

        System.out.println("updateRecordsWithDummyData()");
        System.out.println("Result from updateRecordsWithDummyData = " + Arrays.toString(employeeDao.updateRecordsWithDummyData()));
        employeeDao.findEmployees()
                .forEach(System.out::println);

        System.out.println("Employee Report Stop");
    }
}
