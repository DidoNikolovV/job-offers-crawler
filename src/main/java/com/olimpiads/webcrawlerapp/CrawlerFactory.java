package com.olimpiads.webcrawlerapp;

public class CrawlerFactory {
    public static Crawler creatCrawler(String url) {
        if(url == null) {
            throw new IllegalArgumentException("Url cannot be null");
        }

        if(url.contains("dev.bg")) {
            return new DevBgCrawler();
        }

        throw new IllegalArgumentException("Unknown url type");
    }
}
