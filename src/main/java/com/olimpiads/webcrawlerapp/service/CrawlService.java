package com.olimpiads.webcrawlerapp.service;


import com.olimpiads.webcrawlerapp.ObjectPool;
import com.olimpiads.webcrawlerapp.crawler.Crawler;
import com.olimpiads.webcrawlerapp.model.dto.WebsitesDto;
import com.olimpiads.webcrawlerapp.model.entity.JobOffer;
import com.olimpiads.webcrawlerapp.repository.JobOffersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class CrawlService {

    private final JobOffersRepository jobOffersRepository;

    public CrawlService(JobOffersRepository jobOffersRepository) {
        this.jobOffersRepository = jobOffersRepository;
    }

    public void crawlJobs(WebsitesDto websitesDto) {
        List<String> websites = websitesDto.websites();
        ObjectPool pool = new ObjectPool(websites);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (String site : websites) {
            executorService.submit(() -> {
                Crawler crawler = pool.acquireCrawler(site);
                try {
                    List<JobOffer> crawl = crawler.crawl(site);
                    jobOffersRepository.saveAll(crawl);
                } catch (IOException e) {
                    log.error(e.getMessage());
                } finally {
                    pool.release(site, crawler);
                }
            });
        }

        executorService.shutdown();
    }

    public List<JobOffer> getJobOffers(String website) {
        return jobOffersRepository.findAllBySiteId(website);
    }
}
