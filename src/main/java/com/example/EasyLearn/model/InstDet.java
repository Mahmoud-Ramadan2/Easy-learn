package com.example.EasyLearn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_details")
public class InstDet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="youtube-chanel")
    private String youtubeChannel;

    private String hoppy;


    // add this for BiDirection relationship
    @OneToOne(mappedBy = "instDet", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instrcutor;

    public InstDet() {
    }

    public InstDet(String hoppy, String youtubeChannel) {
        this.hoppy = hoppy;
        this.youtubeChannel = youtubeChannel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoppy() {
        return hoppy;
    }

    public void setHoppy(String hoppy) {
        this.hoppy = hoppy;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public Instructor getInstrcutor() {
        return instrcutor;
    }

    public void setInstrcutor(Instructor instrcutor) {
        this.instrcutor = instrcutor;
    }
}
