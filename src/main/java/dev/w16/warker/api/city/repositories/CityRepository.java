package dev.w16.warker.api.city.repositories;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dev.w16.warker.api.city.models.City;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
  Page<City> findAll(Pageable pageable);

  Iterable<City> findAll(Sort sort);

  Optional<City> findById(Long id);

  Optional<City> findByIbgeCode(Integer ibgeCode);

  Iterable<City> findAllById(Iterable<Long> ids);
}
