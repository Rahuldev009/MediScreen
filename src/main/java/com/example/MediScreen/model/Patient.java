package com.example.MediScreen.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "p_name")
    String patientName;
    @Column(name = "f_name")
    String FamilyName;
    @Column(name = "dob")
    String dateOfBirth;
    String sex;
    @Column(name = "home_address")
    String homeAddress;
    @Column(name = "phone")
    String phoneNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public void setFamilyName(String familyName) {
        FamilyName = familyName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", FamilyName='" + FamilyName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex='" + sex + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
