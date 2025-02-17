package com.olimpiads.webcrawlerapp.crawler;

import com.olimpiads.webcrawlerapp.ObjectPool;

import java.util.List;

public class CrawlerManager {
    private static CrawlerManager instance;
    private final ObjectPool pool;

    private CrawlerManager() {
        this.pool = new ObjectPool(List.of("linkedin", "dev.bg"));
    }

    public static synchronized CrawlerManager getInstance() {
        if (instance == null) {
            instance = new CrawlerManager();
        }
        return instance;
    }

    public ObjectPool getCrawlerPool() {
        return pool;
    }
}
