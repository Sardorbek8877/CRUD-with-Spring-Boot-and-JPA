package uz.bek.springboottask_6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surName;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false)
    private Date issuedDate;

    @Column(nullable = false, unique = true)
    private String passportId;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String region;
}
