package com.cleancode.houseutils.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author claire
 */

@Entity
@Getter
@Setter

public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String address;

    @Column(nullable = false)
    public Long price;

}
