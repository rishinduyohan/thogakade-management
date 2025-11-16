package edu.icet.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String id;
    private String title;
    private String name;
    private Date date;
    private double salary;
    private String address;
    private String city;
    private String province;
    private String postalCode;
}
