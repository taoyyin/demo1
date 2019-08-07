package com.example1.demo1.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnityModel {
    String title;
    String content;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UnityModel{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", id=" + id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
