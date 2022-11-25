package com.ilionx.lab.swamp.controller;


import com.ilionx.lab.swamp.model.Location;
import com.ilionx.lab.swamp.model.Organisation;
import com.ilionx.lab.swamp.repository.LocationRepository;
import com.ilionx.lab.swamp.repository.OrganisationRepository;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrganisationController {

  private final OrganisationRepository organisationRepository;
  private final LocationRepository locationRepository;

  public OrganisationController(OrganisationRepository organisationRepository,
      LocationRepository locationRepository) {
    this.organisationRepository = organisationRepository;
    this.locationRepository = locationRepository;
  }

  @QueryMapping
  public List<Organisation> listOrganisations(@Argument int count, @Argument int offset) {

    Sort sortByName = Sort.sort(Organisation.class)
        .by(Organisation::getName)
        .ascending();

    PageRequest pageable = PageRequest.of(offset / count, count, sortByName);
    return organisationRepository.findAll(pageable).getContent();
  }

  @SchemaMapping
  public List<Location> locations(Organisation organisation) {
    return locationRepository.findByOrganisationId(organisation.getId());
  }
}
