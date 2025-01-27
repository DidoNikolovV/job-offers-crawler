package com.olimpiads.webcrawlerapp;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Job {
    private String title;
    private String url;

    @Override
    public String toString() {
        return "title='" + title + "\n" +
                "url='" + url;
    }
}
