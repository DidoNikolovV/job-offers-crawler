package com.olimpiads.webcrawlerapp.web;


import com.olimpiads.webcrawlerapp.model.dto.WebsitesDto;
import com.olimpiads.webcrawlerapp.model.entity.JobOffer;
import com.olimpiads.webcrawlerapp.service.CrawlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Start job crawling", description = "Triggers crawling for the given websites.")
    @ApiResponse(responseCode = "204", description = "Crawling started successfully")
    @PostMapping
    public ResponseEntity<String> crawlWebsites(@RequestBody WebsitesDto request) {
        crawlService.crawlJobs(request);
        return ResponseEntity.ok("Crawling started successfully");
    }

    @Operation(summary = "Get job offers", description = "Fetches job offers for a specific website")
    @ApiResponse(responseCode = "200", description = "List of job offers",
            content = @Content(schema = @Schema(implementation = JobOffer.class)))
    @GetMapping("/{website}")
    public ResponseEntity<List<JobOffer>> getJobOffers(@PathVariable("website") String website) {
        return ResponseEntity.ok(crawlService.getJobOffers(website));
    }
}
