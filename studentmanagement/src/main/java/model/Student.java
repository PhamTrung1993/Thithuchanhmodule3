package model;

import java.sql.Date;

public class Student {
    protected int id;
    protected String studentName;
    protected Date dateOfBirth;
    protected String address;
    protected String phoneNumber;
    protected String email;
    protected String classRoom;
    protected int classRoomID;


    public Student() {
    }

    public Student(String studentName, Date dateOfBirth, String address, String phoneNumber, String email, String classRoom) {
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classRoom = classRoom;
    }

    public Student(int id, String studentName, Date dateOfBirth, String address, String phoneNumber, String email) {
        this.id = id;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Student(int id, String studentName, Date dateOfBirth, String address, String phoneNumber, String email, String classRoom) {
        this.id = id;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classRoom = classRoom;
    }

    public Student(int id, String studentName, Date dateOfBirth, String address, String phoneNumber, String email, int classRoomID) {
        this.id = id;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.classRoomID = classRoomID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public int getClassRoomID() {
        return classRoomID;
    }

    public void setClassRoomID(int classRoomID) {
        this.classRoomID = classRoomID;
    }
}
