package com.ilionx.lab.swamp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Entity
public class Location {
  @Id
  private Integer id;
  private String name;
  private Integer organisationId;
}
