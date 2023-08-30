package demo.backend.backenddemo.service.impl;

import demo.backend.backenddemo.exception.ResourceNotFoundException;
import demo.backend.backenddemo.model.Employee;
import demo.backend.backenddemo.repository.EmployeeRepository;
import demo.backend.backenddemo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Employee getEmployeeByID(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            //.get method returns the content of the optional object
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }

        // Can use lambda expressions
        // return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }
}
