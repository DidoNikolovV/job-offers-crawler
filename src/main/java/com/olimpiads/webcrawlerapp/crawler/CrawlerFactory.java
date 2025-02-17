package com.olimpiads.webcrawlerapp.crawler;

public class CrawlerFactory {
    public static Crawler createCrawler(String url) {
        if (url.contains("dev.bg")) {
            return new DevBgCrawler();
        }
        if (url.contains("linkedin")) {
            return new LinkedInCrawler();
        }

        throw new IllegalArgumentException("Unknown url type: " + url);
    }
}
