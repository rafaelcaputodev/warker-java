package dev.w16.warker.api.city.dtos;

import dev.w16.warker.api.gasStation.models.GasStation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityRequestDTO implements Serializable {

    private Long id;
    private String name;
    private Integer ibgeCode;
    private Float latitude;
    private Float longitude;
    private List<GasStation> gasStations = new ArrayList<>();
}
