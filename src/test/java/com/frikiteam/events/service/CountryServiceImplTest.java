package com.frikiteam.events.service;


import com.frikiteam.events.domain.model.Country;
import com.frikiteam.events.domain.repositories.CountryRepository;
import com.frikiteam.events.domain.service.ICountryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CountryServiceImplTest {
    @MockBean
    private CountryRepository countryRepository;

    @Autowired
    private ICountryService countryService;

    @TestConfiguration
    static class CountryServiceTestConfiguration {
        @Bean
        public ICountryService countryService() {
            return new CountryServiceImplementation();
        }
    }


    @Test
    public void whenCreateCountryWithIdsValidThenReturnsCountry() {

        long countryId = 1;

        Country country = new Country();
        country.setId(countryId);

        when(countryRepository.save(country)).thenReturn(country);

        // Act
        Country result = countryService.createCountry(country);

        // Assert
        assertThat(result).isEqualTo(country);
    }

    @Test
    public void whenGetAllCountriesWithData(){
        Long countryId = 1L;
        Country country = new Country();
        country.setId(countryId);

        List<Country> countries = new ArrayList<>();
        countries.add(country);

        when(countryRepository.findAll()).thenReturn(countries);

        // Act
        Page<Country> results = countryService.getAllCountries(null);

        // Assert
        assertThat(results);
    }

    @Test
    public void WhenGetACountryWithExistingId(){
        long countryId = 1;
        Country country = new Country();
        country.setId(countryId);
        when(countryRepository.findById(countryId)).thenReturn(Optional.of(country));

        Country result = countryService.getCountryById(countryId);
        assertThat(result).isEqualTo(country);
    }


    @Test
    public void WhenUpdateACountryWithExistingId(){
        long countryId = 1;
        Country country = new Country();
        country.setId(countryId);
        country.setName("Peru");

        Country countryUp = new Country();
        countryUp.setName("Bolivia");

        when(countryRepository.findById(countryId)).thenReturn(Optional.of(country));
        when(countryRepository.save(country)).thenReturn(country);


        Country result = countryService.updateCountry(countryId,countryUp);
        country.setName(countryUp.getName());

        assertThat(result).isEqualTo(country);
    }

    @Test
    public void WhenDeleteACountryWithExistingId(){
        long countryId = 1;
        Country country = new Country();
        country.setId(countryId);
        country.setName("PERU");

        when(countryRepository.findById(countryId)).thenReturn(Optional.of(country));
        ResponseEntity<?> result = countryService.deleteCountry(countryId);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }




}
