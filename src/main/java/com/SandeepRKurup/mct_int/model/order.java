package com.SandeepRKurup.mct_int.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "table_order")
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderid;
    private String productid;
    private String userid;
    private String paymentid;
    private String count;
}
