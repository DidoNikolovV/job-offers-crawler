package com.olimpiads.webcrawlerapp;

import com.olimpiads.webcrawlerapp.crawler.Crawler;
import com.olimpiads.webcrawlerapp.crawler.CrawlerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ObjectPool {

    @Value("${pool.size}")
    private int POOL_SIZE;
    private final Map<String, Queue<Crawler>> pool = new HashMap<>();

    public ObjectPool(List<String> websites) {
        for (String site : websites) {
            pool.put(site, new LinkedList<>());
        }
    }

    public synchronized Crawler acquireCrawler(String website) {
        Queue<Crawler> queue = pool.getOrDefault(website, new LinkedList<>());
        if (queue.isEmpty()) {
            return CrawlerFactory.createCrawler(website);
        }
        return queue.poll();
    }

    public synchronized void release(String source, Crawler crawler) {
        Queue<Crawler> queue = pool.get(source);
        if (queue != null && queue.size() < POOL_SIZE) {
            queue.offer(crawler);
        }
    }
}
