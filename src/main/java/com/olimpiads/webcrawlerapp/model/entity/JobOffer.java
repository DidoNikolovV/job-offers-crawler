package com.olimpiads.webcrawlerapp.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_offers")
public class JobOffer {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String url;
    private String siteId;

    @Override
    public String toString() {
        return "Title: " + title +
                ", URL: " + url;
    }
}
