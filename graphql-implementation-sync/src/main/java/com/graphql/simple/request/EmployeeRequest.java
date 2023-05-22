package com.graphql.simple.request;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class EmployeeRequest {

    private int empId;
    private String name;
    private int age;
    private String phone;
    private String nationality;
}
