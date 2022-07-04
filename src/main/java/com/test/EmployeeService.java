package com.test;

import com.test.dto.EmployeeFirstNameAndLastNameView;
import com.test.dto.EmployeeFullNameView;
import com.test.dto.EmployeeIdAndSalaryView;
import com.test.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public boolean save(Employee employee) {
        Integer id = employee.getId();
        if(id !=null && repository.existsById(id))
            return false;
        repository.save(employee);
        return true;
    }

    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    public List<EmployeeFirstNameAndLastNameView> getAllEmployeeName() {
        return repository.findAllEmployeeNameProjectedBy();
    }
    public List<EmployeeIdAndSalaryView> getAllEmployeeIdAndSalary() {
        return repository.findAllEmployeeIdAndSalaryViewProjectedBy();
    }

    public List<EmployeeFirstNameAndLastNameView> getAllEmployeeNameByFirstName(String name) {
        return repository.findAllProjectedByFirstName(name);
    }

    public List<EmployeeFullNameView> getAllEmployeeFullName() {
        return repository.findAllFullNameProjectedBy();
    }

    public Collection getAllEmployeeByView(String view){
        if("EmployeeFullName".equalsIgnoreCase(view))
            return repository.findAllProjectedBy(EmployeeFullNameView.class);
        else if ("EmployeeIdAndSalary".equalsIgnoreCase(view))
            return repository.findAllProjectedBy(EmployeeIdAndSalaryView.class);
        else if("EmployeeFirstNameAndLastName".equalsIgnoreCase(view))
            return repository.findAllProjectedBy(EmployeeFirstNameAndLastNameView.class);
        else if("Employee".equalsIgnoreCase(view))
            return repository.findAllProjectedBy(Employee.class);
        else
            return null;
    }
}
