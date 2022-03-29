package dev.w16.warker.api.city.dtos;

import dev.w16.warker.api.city.models.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityResponseDTO implements Serializable {

    private String name;
    private Integer ibgeCode;
    private CordenadasDTO cordenadas;

    public CityResponseDTO(City entity) {
        name = entity.getName();
        ibgeCode = entity.getIbgeCode();
    }
}
