package com.test;

import com.test.dto.EmployeeFirstNameAndLastNameView;
import com.test.dto.EmployeeFullNameView;
import com.test.dto.EmployeeIdAndSalaryView;
import com.test.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/emp")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
        if(service.save(employee))
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/emp")
    public List<Employee> getAllEmployee(){
        return service.getAllEmployee();
    }

    @GetMapping("/emp/name")

    public List<EmployeeFirstNameAndLastNameView> getAllEmployeeName() {
        return service.getAllEmployeeName();
    }
    @GetMapping("/emp/full-name")

    public List<EmployeeFullNameView> getAllEmployeeFullName() {
        return service.getAllEmployeeFullName();
    }

    @GetMapping("/emp/first-name/{name}")
    public List<EmployeeFirstNameAndLastNameView> getAllEmployeeNameByFirstName(@PathVariable String name) {
        return service.getAllEmployeeNameByFirstName(name);
    }

    @GetMapping("/emp/id-salary")
    public List<EmployeeIdAndSalaryView> getAllEmployeeIdAndSalary() {
        return service.getAllEmployeeIdAndSalary();
    }

    @GetMapping("/emp/type/{view}")
    public Collection getAllEmployeeByView(@PathVariable String view) {
        return service.getAllEmployeeByView(view);
    }
}
