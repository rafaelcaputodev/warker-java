package dev.w16.warker.api.city.controllers;

import dev.w16.warker.api.city.dtos.CityRequestDTO;
import dev.w16.warker.api.city.dtos.CityResponseDTO;
import dev.w16.warker.api.city.models.City;
import dev.w16.warker.api.city.services.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;

@RestController
@RequestMapping("api/v1/city")
public class CityController {
  @Autowired
  private CityService cityService;

  @Transactional
  @Operation(summary = "Retrieve all cities.",
      description = "Retrieve all cities registered on the database.")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
  @GetMapping(path = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Page<City>> listAll(
      @PageableDefault(page = 0, size = 10) @ParameterObject Pageable pageable) {
    return new ResponseEntity<>(cityService.findAll(pageable), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<CityResponseDTO> insertCity(@RequestBody CityRequestDTO dto){
    CityResponseDTO cityResponseDTO = cityService.insertCity(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
    return ResponseEntity.created(uri).body(cityResponseDTO);
  }
}
