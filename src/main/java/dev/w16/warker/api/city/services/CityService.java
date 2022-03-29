package dev.w16.warker.api.city.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import dev.w16.warker.api.city.models.City;
import dev.w16.warker.api.city.repositories.CityRepository;

@Service
public class CityService {
  @Autowired
  private CityRepository cityRepository;

  public Page<City> findAll(Pageable pageable) {
    return cityRepository.findAll(pageable);
  }
}
