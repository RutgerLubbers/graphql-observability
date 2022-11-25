package com.ilionx.lab.swamp.controller;

import static org.slf4j.LoggerFactory.getLogger;

import com.ilionx.lab.swamp.model.Location;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

  private static final Logger LOGGER = getLogger(DummyController.class);


  @GetMapping("/dummy")
  public ResponseEntity<Location> dummy() {
    LOGGER.info("In /dummy.");
    return ResponseEntity.ok(Location.builder().id(-1).name("bla").build());
  }
}
