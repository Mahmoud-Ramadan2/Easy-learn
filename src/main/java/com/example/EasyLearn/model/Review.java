package com.example.EasyLearn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "comment")
    private String Comment;
    @ManyToOne()
    @JoinColumn(name = "course_id")
    Course course;

    public Review(){

    }

    public Review(String comment) {
        Comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", Comment='" + Comment + '\'' +
                ", course=" + course +
                '}';
    }

}