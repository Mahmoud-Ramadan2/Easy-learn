package com.example.EasyLearn.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first-name")
    private String fName;

    @Column(name = "last-name")
    private String lName;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Inst-details-id")
    private InstDet instDet;

    @OneToMany(mappedBy = "instrcutor",fetch = FetchType.LAZY, cascade ={CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Course> courses;


    public Instructor() {
    }

    public Instructor(String fName, String lName) {
        this.lName = lName;
        this.fName = fName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public InstDet getInstDet() {
        return instDet;
    }

    public void setInstDet(InstDet instDet) {
        this.instDet = instDet;
        instDet.setInstrcutor(this);  //to sure  Bi-Directional
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Convenience method to  Bi-Directional
    public void add(Course tempCourse){
        if(courses == null){
            courses = new ArrayList<>();
        }
        courses.add(tempCourse);
        tempCourse.setInstrcutor(this);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
