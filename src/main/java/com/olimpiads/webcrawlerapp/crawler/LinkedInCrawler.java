package com.olimpiads.webcrawlerapp.crawler;

import com.olimpiads.webcrawlerapp.model.entity.JobOffer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkedInCrawler implements Crawler {
    @Override
    public List<JobOffer> crawl(String website) throws IOException {
        Document doc = Jsoup.connect(website).get();
        Elements jobElements = doc.select(".base-card__full-link");
        List<JobOffer> jobOffers = new ArrayList<>();
        for (Element el : jobElements) {
            String title = el.text();
            String url = el.absUrl("href");
            JobOffer jobOffer = new JobOffer();
            jobOffer.setTitle(title);
            jobOffer.setUrl(url);
            jobOffer.setSiteId("linkedin");
            jobOffers.add(jobOffer);
//            InMemoryStorage.getInstance().saveJob(website, jobOffer);
        }

        return jobOffers;

//        InMemoryStorage.getInstance().saveJobsToFile(website, "linked-offers.txt");
    }
}
