package com.olimpiads.webcrawlerapp.crawler;

import com.olimpiads.webcrawlerapp.model.entity.JobOffer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DevBgCrawler implements Crawler {

    @Override
    public List<JobOffer> crawl(String website) throws IOException {
        Document document = Jsoup.connect(website).get();
        Elements elementsByClass = document.getElementsByClass("job-list-item");
        List<JobOffer> jobOffers = new ArrayList<>();
        for (var el : elementsByClass) {
            String title = el.getElementsByClass("job-title").getFirst().text();
            String url = el.getElementsByClass("overlay-link").getFirst().absUrl("href");
            JobOffer jobOffer = new JobOffer();
            jobOffer.setTitle(title);
            jobOffer.setUrl(url);
            jobOffer.setSiteId("dev.bg");
            jobOffers.add(jobOffer);
        }

        return jobOffers;
//        InMemoryStorage.getInstance().saveJobsToFile(website, "dev-bg.txt");

    }
}
