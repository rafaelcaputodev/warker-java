package dev.w16.warker.api.city.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import dev.w16.warker.api.gasStation.models.GasStation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private Integer ibgeCode;

  @Column
  private Float latitude;

  @Column
  private Float longitude;

  @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
  @Builder.Default
  private List<GasStation> gasStations = new ArrayList<>();
}
