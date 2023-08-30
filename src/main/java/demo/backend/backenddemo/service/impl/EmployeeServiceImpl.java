package demo.backend.backenddemo.service.impl;

import demo.backend.backenddemo.model.Employee;
import demo.backend.backenddemo.repository.EmployeeRepository;
import demo.backend.backenddemo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

//This class implements the employee service interface
@Service
public class EmployeeServiceImpl implements EmployeeService {
//    Constructor based dependency injection
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
