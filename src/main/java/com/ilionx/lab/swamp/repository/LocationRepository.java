package com.ilionx.lab.swamp.repository;

import com.ilionx.lab.swamp.model.Location;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>, PagingAndSortingRepository<Location, Integer> {

  List<Location> findByOrganisationId(Integer organisationId);

}
