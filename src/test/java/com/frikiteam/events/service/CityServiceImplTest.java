package com.frikiteam.events.service;

import com.frikiteam.events.domain.model.*;
import com.frikiteam.events.domain.repositories.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import com.frikiteam.events.domain.service.ICityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CityServiceImplTest {
    @MockBean
    private CityRepository cityRepository;
    @MockBean
    private CountryRepository countryRepository;

    @Autowired
    private ICityService cityService;

    @TestConfiguration
    static class CityServiceTestConfiguration {
        @Bean
        public ICityService cityService() {
            return new CityServiceImplementation();
        }
    }

    @Test
    public void whenGetAllCitiesByCountryIdWithValidIdThenReturnsCities() {
        // Arrange
        Long countryId = 1L;
        Country country = new Country();
        country.setId(countryId);

        City city = new City();
        city.setId(1L);
        city.setCountry(country);
        List<City> cities = new ArrayList<>();
        cities.add(city);
        country.getCities().add(city);


        when(countryRepository.findById(countryId)).thenReturn(Optional.of(country));
        //when(cityRepository.findAll()).thenReturn(cities);

        // Act
        List<City> results = cityService.getAllCitiesByCountryId(countryId);

        // Assert
        assertThat(results).isEqualTo(cities);
    }

    @Test
    public void whenCreateCityWithIdsValidThenReturnsCity() {
        // Arrange
        long countryId = 1;
        long cityId = 1;
        Country country = new Country();
        country.setId(countryId);
        City city = new City();
        city.setId(cityId);
        city.setCountry(country);

        when(countryRepository.findById(countryId)).thenReturn(Optional.of(country));
        when(cityRepository.save(city)).thenReturn(city);

        // Act
        City result = cityService.createCity(countryId, city);

        // Assert
        assertThat(result).isEqualTo(city);
    }

    @Test
    public void whenGetAllCitiesWithData(){
        Long countryId = 1L;
        Country country = new Country();
        country.setId(countryId);

        City city = new City();
        city.setId(1L);
        city.setCountry(country);
        List<City> cities = new ArrayList<>();
        cities.add(city);

        when(cityRepository.findAll()).thenReturn(cities);

        // Act
        Page<City> results = cityService.getAllCities(null);

        // Assert
        assertThat(results);
    }

    @Test
    public void WhenGetACityWithExistingId(){
        long cityId = 1;
        City city = new City();
        city.setId(cityId);
        when(cityRepository.findById(cityId)).thenReturn(Optional.of(city));

        City result = cityService.getCityById(cityId);
        assertThat(result).isEqualTo(city);
    }

    @Test
    public void WhenUpdateACityWithExistingId(){
        long cityId = 1;
        City city = new City();
        city.setId(cityId);
        city.setName("Callao");

        City cityUp = new City();
        cityUp.setName("Lima");

        when(cityRepository.findById(cityId)).thenReturn(Optional.of(city));
        when(cityRepository.save(city)).thenReturn(city);


        City result = cityService.updateCity(cityId,cityUp);
        city.setName(cityUp.getName());

        assertThat(result).isEqualTo(city);
    }

    @Test
    public void WhenDeleteACityWithExistingId(){
        long cityId = 1;
        City city = new City();
        city.setId(cityId);
        city.setName("Callao");

        when(cityRepository.findById(cityId)).thenReturn(Optional.of(city));
        ResponseEntity<?> result = cityService.deleteCity(cityId);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
