package dev.w16.warker.api.gasStation.repositories;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import dev.w16.warker.api.gasStation.models.GasStation;

@Repository
public interface GasStationRepository extends PagingAndSortingRepository<GasStation, Long> {
  Page<GasStation> findAll(Pageable pageable);

  Iterable<GasStation> findAll(Sort sort);

  Optional<GasStation> findById(Long id);

  Iterable<GasStation> findAllByCityId(Long idCity);

  Iterable<GasStation> findAllById(Iterable<Long> ids);
}
