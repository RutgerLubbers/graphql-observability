package com.ilionx.lab.swamp.repository;

import com.ilionx.lab.swamp.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends  JpaRepository<Organisation, Integer>,PagingAndSortingRepository<Organisation, Integer> {
}
