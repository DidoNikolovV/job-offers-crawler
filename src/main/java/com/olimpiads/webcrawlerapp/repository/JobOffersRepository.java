package com.olimpiads.webcrawlerapp.repository;


import com.olimpiads.webcrawlerapp.model.entity.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOffersRepository extends JpaRepository<JobOffer, Long> {
    List<JobOffer> findAllBySiteId(String website);
}
