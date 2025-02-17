package com.olimpiads.webcrawlerapp.crawler;

import com.olimpiads.webcrawlerapp.model.entity.JobOffer;

import java.io.IOException;
import java.util.List;

public interface Crawler {
    List<JobOffer> crawl(String website) throws IOException;
}
