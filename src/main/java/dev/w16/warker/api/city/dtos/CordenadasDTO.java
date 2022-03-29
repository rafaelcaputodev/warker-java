package dev.w16.warker.api.city.dtos;

import dev.w16.warker.api.city.models.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CordenadasDTO implements Serializable {

    private Float latitude;
    private Float longitude;

    public CordenadasDTO(City entity) {
        latitude = entity.getLatitude();
        longitude = entity.getLongitude();
    }
}
