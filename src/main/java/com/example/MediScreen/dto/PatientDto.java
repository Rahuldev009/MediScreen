//package com.example.MediScreen.dto;
//
//import com.example.MediScreen.model.Patient;
//
//import java.time.LocalDate;
//
//public class PatientDto{
//    Integer id;
//    String patientName;
//    String FamilyName;
//    String dateOfBirth;
//    String sex;
//    String homeAddress;
//    String phoneNo;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getPatientName() {
//        return patientName;
//    }
//
//    public void setPatientName(String patientName) {
//        this.patientName = patientName;
//    }
//
//    public String getFamilyName() {
//        return FamilyName;
//    }
//
//    public void setFamilyName(String familyName) {
//        FamilyName = familyName;
//    }
//
//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public String getHomeAddress() {
//        return homeAddress;
//    }
//
//    public void setHomeAddress(String homeAddress) {
//        this.homeAddress = homeAddress;
//    }
//
//    public String getPhoneNo() {
//        return phoneNo;
//    }
//
//    public void setPhoneNo(String phoneNo) {
//        this.phoneNo = phoneNo;
//    }
//
//    @Override
//    public String toString() {
//        return "PatientDto{" +
//                "id=" + id +
//                ", patientName='" + patientName + '\'' +
//                ", FamilyName='" + FamilyName + '\'' +
//                ", dateOfBirth=" + dateOfBirth +
//                ", sex='" + sex + '\'' +
//                ", homeAddress='" + homeAddress + '\'' +
//                ", phoneNo='" + phoneNo + '\'' +
//                '}';
//    }
//
//    public void setPatientDto(Patient patient){
//        setId(patient.getId());
//        setPatientName(patient.getPatientName());
//        setFamilyName(patient.getFamilyName());
//        setDateOfBirth(patient.getDateOfBirth());
//        setSex(patient.getSex());
//        setHomeAddress(patient.getHomeAddress());
//        setPhoneNo(patient.getPhoneNo());
//    }
//
//}
