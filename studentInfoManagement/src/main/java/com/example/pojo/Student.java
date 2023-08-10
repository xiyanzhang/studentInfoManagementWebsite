package com.example.pojo;

public class Student {

    private String name;
    private Integer studentId;
    private Integer age;
    private String gender;
    private long phoneNumber;
    private String politicalStatus;
    private String ethnicGroup;
    private String birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getEthnicGroup() {
        return ethnicGroup;
    }

    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }


    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\",\"studentId\":\"" + studentId + "\",\"age\":\"" + age +
            "\",\"gender\":\"" + gender + "\",\"phoneNumber\":\"" + phoneNumber +
            "\",\"politicalStatus\":\"" + politicalStatus + "\",\"ethnicGroup\":\"" +
            ethnicGroup + "\",\"birthdate\":\"" + birthdate + "\"}";
    }

}
