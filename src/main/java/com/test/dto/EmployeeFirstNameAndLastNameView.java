package com.test.dto;

import lombok.Value;

//class based projection


/*
@Data
@AllArgsConstructor
public class EmployeeFirstNameAndLastNameView {
    private String firstName;
    private String lastName;
}
*/

@Value
public class EmployeeFirstNameAndLastNameView {
    private String firstName,lastName;
}
