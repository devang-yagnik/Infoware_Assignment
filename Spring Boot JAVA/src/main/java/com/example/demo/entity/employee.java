package com.example.demo.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees_java")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "primaryEmergencyContact")
    private String primaryEmergencyContact;

    @Column(name = "primaryEmergencyContactPhone")
    private String primaryEmergencyContactPhone;

    @Column(name = "primaryEmergencyContactRelationship")
    private String primaryEmergencyContactRelationship;

    @Column(name = "secondaryEmergencyContact")
    private String secondaryEmergencyContact;

    @Column(name = "secondaryEmergencyContactPhone")
    private String secondaryEmergencyContactPhone;

    @Column(name = "secondaryEmergencyContactRelationship")
    private String secondaryEmergencyContactRelationship;
}
