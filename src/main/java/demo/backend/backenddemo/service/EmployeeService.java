package demo.backend.backenddemo.service;

import demo.backend.backenddemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
}
