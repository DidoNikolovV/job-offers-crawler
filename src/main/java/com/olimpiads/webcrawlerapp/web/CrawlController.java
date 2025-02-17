package com.olimpiads.webcrawlerapp.web;


import com.olimpiads.webcrawlerapp.model.dto.WebsitesDto;
import com.olimpiads.webcrawlerapp.model.entity.JobOffer;
import com.olimpiads.webcrawlerapp.service.CrawlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crawl")
public class CrawlController {

    private final CrawlService crawlService;

    public CrawlController(CrawlService crawlService) {
        this.crawlService = crawlService;
    }

    @PostMapping
    public ResponseEntity<Void> crawlWebsites(@RequestBody WebsitesDto request) {
        crawlService.crawlJobs(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{website}")
    public ResponseEntity<List<JobOffer>> getJobOffers(@PathVariable("website") String website) {
        return ResponseEntity.ok(crawlService.getJobOffers(website));
    }
}
