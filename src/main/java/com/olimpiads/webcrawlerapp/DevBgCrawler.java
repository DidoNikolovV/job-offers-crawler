package com.olimpiads.webcrawlerapp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DevBgCrawler implements Crawler {
    private final InMemoryStorage storage = InMemoryStorage.getInstance();

    @Override
    public void crawl(String website) throws IOException {
        Document document = Jsoup.connect(website).get();
        Elements elementsByClass = document.getElementsByClass("job-list-item");

        for (var el : elementsByClass) {
            String title = el.getElementsByClass("job-title").getFirst().text();
            String url = el.getElementsByClass("overlay-link").getFirst().absUrl("href");
            Job job = new Job(title, url);
            storage.saveJob(job);
        }
        storage.saveJobsToFile("devbg-jobs");

    }
}
