package com.gsg.paltechlinker.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gsg.paltechlinker.domain.entities.CompanyEntity;
import com.gsg.paltechlinker.domain.entities.InternshipEntity;

@Repository
public interface InternshipRepository extends CrudRepository<InternshipEntity, Long>,
                                            PagingAndSortingRepository<InternshipEntity, Long> {    
    
}
