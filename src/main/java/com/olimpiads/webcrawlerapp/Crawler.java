package com.olimpiads.webcrawlerapp;

import java.io.IOException;

public interface Crawler {
    void crawl(String website) throws IOException;
}
