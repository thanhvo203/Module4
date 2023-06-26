package com.example.demo.dto;


import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Max;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SongCreateDto {

    private int id;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Not Special characters")
//    @Max(value = 800)
    private String nameSong;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Not Special characters")
//    @Max(value = 300)
    private String singer;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z ,]+$", message = "Not Special characters")
//    @Max(value = 1000)
    private String typeSong;

    private  boolean checkStatus;

    public SongCreateDto(int id, String nameSong, String singer, String typeSong, boolean checkStatus) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.typeSong = typeSong;
        this.checkStatus = checkStatus;
    }

    public SongCreateDto(String nameSong, String singer, String typeSong, boolean checkStatus) {
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

    public SongCreateDto() {
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
