package com.olimpiads.webcrawlerapp.service;

import com.olimpiads.webcrawlerapp.ObjectPool;
import com.olimpiads.webcrawlerapp.crawler.Crawler;
import com.olimpiads.webcrawlerapp.model.dto.WebsitesDto;
import com.olimpiads.webcrawlerapp.model.entity.JobOffer;
import com.olimpiads.webcrawlerapp.repository.JobOffersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CrawlServiceTest {

    @Mock
    private JobOffersRepository jobOffersRepository;

    @Mock
    private ObjectPool objectPool;

    @Mock
    private Crawler mockCrawler;

    @InjectMocks
    private CrawlService crawlService;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrawlServiceCrawlsJobs() {
        // Arrange
        List<String> websites = List.of("https://dev.bg/company/jobads/egt-digital-senior-net-developer-retail-1/");
        WebsitesDto request = new WebsitesDto(websites);

        assertDoesNotThrow(() -> crawlService.crawlJobs(request));
    }

    @Test
    void testGetJobOffersReturnsCorrectJobs() {
        List<JobOffer> mockJobs = List.of(new JobOffer(1, "Java Developer", "https://linkedin", "linkedin"));
        when(jobOffersRepository.findAllBySiteId("linkedin")).thenReturn(mockJobs);

        List<JobOffer> jobs = crawlService.getJobOffers("linkedin");

        assertEquals(1, jobs.size());
        assertEquals("Java Developer", jobs.get(0).getTitle());
        assertEquals("https://linkedin", jobs.get(0).getUrl());
    }
}