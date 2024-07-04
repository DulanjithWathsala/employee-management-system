package edu.icet.ems.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String email;
    private String address;
}
