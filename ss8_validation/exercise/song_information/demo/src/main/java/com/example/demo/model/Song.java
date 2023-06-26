package com.example.demo.model;

import sun.jvm.hotspot.gc.g1.G1HeapRegionTable;

import javax.persistence.*;

@Entity
@Table (name = "song")
public class Song {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String nameSong;
    private String singer;

    private String typeSong;
    private boolean checkStatus;

    public Song(int id, String nameSong, String singer, String typeSong,boolean checkStatus) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.typeSong = typeSong;
        this.checkStatus = checkStatus;
    }

    public Song(String nameSong, String singer, String typeSong,boolean checkStatus) {
        this.nameSong = nameSong;
        this.singer = singer;
        this.typeSong = typeSong;
        this.checkStatus = checkStatus;
    }

    public boolean isCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Song() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeSong() {
        return typeSong;
    }

    public void setTypeSong(String typeSong) {
        this.typeSong = typeSong;
    }
}
