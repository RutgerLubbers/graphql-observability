package com.ilionx.lab.swamp;

import com.ilionx.lab.swamp.model.Location;
import com.ilionx.lab.swamp.model.Organisation;
import com.ilionx.lab.swamp.repository.LocationRepository;
import com.ilionx.lab.swamp.repository.OrganisationRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements ApplicationRunner {

  private final OrganisationRepository organisationRepository;
  private final LocationRepository locationRepository;

  public ApplicationInitializer(OrganisationRepository organisationRepository,
      LocationRepository locationRepository) {
    this.organisationRepository = organisationRepository;
    this.locationRepository = locationRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    int i = 0;
    // Some random dutch supermarkets
    Organisation albertHeijn = new Organisation(i++, "Albert Heijn");
    organisationRepository.save(albertHeijn);
    Organisation plusMarkt = new Organisation(i++, "Plusmarkt");
    organisationRepository.save(plusMarkt);
    Organisation janLinders = new Organisation(i++, "Jan Linders");
    organisationRepository.save(janLinders);
    Organisation jumbo = new Organisation(i++, "Jumbo");
    organisationRepository.save(jumbo);

    // Some random places in .nl
    locationRepository.save(new Location(i++, "Heerlen", albertHeijn.getId()));
    locationRepository.save(new Location(i++, "Sittard", albertHeijn.getId()));

    locationRepository.save(new Location(i++, "Heerlen", plusMarkt.getId()));
    locationRepository.save(new Location(i++, "Zoetermeer", plusMarkt.getId()));

    locationRepository.save(new Location(i++, "Amsterdam", janLinders.getId()));
    locationRepository.save(new Location(i++, "Bunde", janLinders.getId()));

    locationRepository.save(new Location(i++, "Tilburg", jumbo.getId()));
    locationRepository.save(new Location(i++, "Veghel", jumbo.getId()));

  }

}
