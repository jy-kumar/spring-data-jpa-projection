package com.test.dto;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeFullNameView {
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}
