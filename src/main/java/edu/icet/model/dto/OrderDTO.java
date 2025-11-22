package edu.icet.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String orderId;
    private String orderDate;
    private String custID;
}
