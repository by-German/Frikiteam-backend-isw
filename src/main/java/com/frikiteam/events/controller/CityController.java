package com.frikiteam.events.controller;

import com.frikiteam.events.domain.model.City;
import com.frikiteam.events.domain.service.ICityService;
import com.frikiteam.events.resource.CityResource;
import com.frikiteam.events.resource.SaveCityResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CityController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ICityService cityService;
    //Conversiones
    private City convertToEntity(SaveCityResource resource){
        return mapper.map(resource,City.class);
    }
    private CityResource convertToResource(City entity){
        return mapper.map(entity,CityResource.class);
    }

    @GetMapping("/cities")
    public Page<CityResource> getAllCities(Pageable pageable){
        List<CityResource> resources = cityService.getAllCities(pageable)
                .getContent().stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @PostMapping("/countries/{countryId}/cities") // to see
    public CityResource createCity(@PathVariable Long countryId, @Valid @RequestBody SaveCityResource resource){
        City city = convertToEntity(resource);
        return convertToResource(cityService.createCity(countryId, city));
    }

    @PutMapping("/cities/{cityId}")
    public CityResource updateCity(@PathVariable Long cityId, @RequestBody SaveCityResource resource){
        City city = convertToEntity(resource);
        return convertToResource(cityService.updateCity(cityId,city));
    }

    @DeleteMapping("/cities/{cityId}")
    public ResponseEntity<?> deleteCity(@PathVariable Long cityId)
    {
        return cityService.deleteCity(cityId);
    }

    @GetMapping("/cities/{cityId}")
    public CityResource getCityById(@PathVariable Long cityId){
        return convertToResource(cityService.getCityById(cityId));
    }
}
