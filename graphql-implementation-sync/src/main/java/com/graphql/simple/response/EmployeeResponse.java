package com.graphql.simple.response;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class EmployeeResponse {

    private int empId;
    private String name;
    private int age;
    private String phone;
    private String nationality;
}
