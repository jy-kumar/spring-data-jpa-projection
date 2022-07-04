package com.test;

import com.test.dto.EmployeeFirstNameAndLastNameView;
import com.test.dto.EmployeeFullNameView;
import com.test.dto.EmployeeIdAndSalaryView;
import com.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<EmployeeFirstNameAndLastNameView> findAllEmployeeNameProjectedBy();
    List<EmployeeFirstNameAndLastNameView> findAllProjectedByFirstName(String name);
    List<EmployeeIdAndSalaryView> findAllEmployeeIdAndSalaryViewProjectedBy();
    List<EmployeeFullNameView> findAllFullNameProjectedBy();
    //ProjectionViewName is not mandatory in method name
    //List<EmployeeFullNameView> findAllEmployeeFullNameViewProjectedBy();

    //Dynamic Projection
    <T> Collection<T> findAllProjectedBy(Class<T> type);
}
