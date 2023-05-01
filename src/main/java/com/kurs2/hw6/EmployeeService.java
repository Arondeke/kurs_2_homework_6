package com.kurs2.hw6;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public Employee newEmployee(String firsName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firsName) && employee.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyExistException();
            }
        }
        var test = new Employee(firsName, lastName);
        employees.add(test);
        return test;
    }

    public Employee deleteEmployee(String firsName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firsName) && employee.getLastName().equals(lastName)) {
                employees.remove(employee);
            }
        }
        throw new EmployeeAlreadyDeleteException();
    }

    public Employee getEmployee(String firsName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firsName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
        //return employee;
    }

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        service.newEmployee("test1", "test2");
        service.getEmployee("test1", "test2");
        //     System.out.println(service.getEmploee("test1", "test2"));
        //     service.getEmploee("qwert", "asdf");
    }
}