package dev.w16.warker.api.city.services;

import dev.w16.warker.api.city.dtos.CityRequestDTO;
import dev.w16.warker.api.city.dtos.CityResponseDTO;
import dev.w16.warker.api.city.dtos.CordenadasDTO;
import dev.w16.warker.api.city.models.City;
import dev.w16.warker.api.city.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CityService {

  private final CityRepository cityRepository;

  @Autowired
  public CityService(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  public Page<City> findAll(Pageable pageable) {
    return cityRepository.findAll(pageable);
  }

  @Transactional
  public CityResponseDTO insertCity(CityRequestDTO cityRequestDTO){
    City entity = new City();
    copyDtoToEntity(cityRequestDTO, entity);
    entity = cityRepository.save(entity);
    CityResponseDTO cityResponseDTO = new CityResponseDTO(entity);
    CordenadasDTO cordenadasDTO = new CordenadasDTO(entity);
    cityResponseDTO.setCordenadas(cordenadasDTO);
    return cityResponseDTO;
  }

  public void copyDtoToEntity(CityRequestDTO dto, City entity){
    entity.setName(dto.getName());
    entity.setIbgeCode(dto.getIbgeCode());
    entity.setLatitude(dto.getLatitude());
    entity.setLongitude(dto.getLongitude());
  }
}
