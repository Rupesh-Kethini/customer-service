package com.hotel.customerservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {


    private Long customerId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

    private LocalDateTime createdAt;

}
