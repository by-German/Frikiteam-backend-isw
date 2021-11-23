package com.frikiteam.events.service;


import com.frikiteam.events.domain.model.City;
import com.frikiteam.events.domain.model.Country;
import com.frikiteam.events.domain.model.District;
import com.frikiteam.events.domain.repositories.CityRepository;
import com.frikiteam.events.domain.repositories.DistrictRepository;
import com.frikiteam.events.domain.service.ICountryService;
import com.frikiteam.events.domain.service.IDistrictService;
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
public class DistrictServiceImplTest {
    @MockBean
    private DistrictRepository districtRepository;
    @MockBean
    private CityRepository cityRepository;

    @Autowired
    private IDistrictService districtService;

    @TestConfiguration
    static class DistrictServiceTestConfiguration {
        @Bean
        public IDistrictService districtService() {
            return new DistrictServiceImplementation();
        }
    }

    @Test
    public void WhenGetADistrictWithExistingId(){
        long districtId = 1;
        District district = new District();
        district.setId(districtId);
        when(districtRepository.findById(districtId)).thenReturn(Optional.of(district));

        District result = districtService.getDistrictById(districtId);
        assertThat(result).isEqualTo(district);
    }

    @Test
    public void whenCreateCountryWithIdsValidThenReturnsCountry() {

        long districtId = 1;
        long cityId = 1;
        City city = new City();
        city.setId(cityId);

        District district = new District();
        district.setId(districtId);
        district.setCity(city);

        when(districtRepository.save(district)).thenReturn(district);
        when(cityRepository.findById(cityId)).thenReturn(Optional.of(city));

        // Act
        District result = districtService.createDistrict(cityId,district);

        // Assert
        assertThat(result).isEqualTo(district);
    }

    @Test
    public void WhenUpdateADistrictWithExistingId(){
        long districtId = 1;
        District district = new District();
        district.setId(districtId);
        district.setName("San Juancho");

        District district1 = new District();
        district1.setName("AAHH");


        when(districtRepository.findById(districtId)).thenReturn(Optional.of(district));
        when(districtRepository.save(district)).thenReturn(district);


        District result = districtService.updateDistrict(districtId,district1);
        district.setName(district1.getName());

        assertThat(result).isEqualTo(district);
    }

    @Test
    public void WhenDeleteADistrictWithExistingId(){
        long districtId = 1;
        District district = new District();
        district.setId(districtId);
        district.setName("SanJ");

        when(districtRepository.findById(districtId)).thenReturn(Optional.of(district));
        ResponseEntity<?> result = districtService.deleteDistrict(districtId);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenGetAllDistrictsWithData(){
        Long districtId = 1L;
        District district = new District();
        district.setId(districtId);

        List<District> districts = new ArrayList<>();
        districts.add(district);

        when(districtRepository.findAll()).thenReturn(districts);

        // Act
        Page<District> results = districtService.getAllDistricts(null);

        // Assert
        assertThat(results);
    }

    @Test
    public void whenGetAllDistrictsByCityIdWithValidIdThenReturnsDistricts() {
        // Arrange
        Long districtId = 1L;
        District district = new District();
        district.setId(districtId);

        Long cityId = 1L;
        City city = new City();
        city.setId(cityId);

        district.setCity(city);
        List<District> districts = new ArrayList<>();
        districts.add(district);
        city.getDistricts().add(district);


        when(cityRepository.findById(cityId)).thenReturn(Optional.of(city));
        //when(cityRepository.findAll()).thenReturn(cities);

        // Act
        List<District> results = districtService.getAllDistrictsByCityId(cityId);

        // Assert
        assertThat(results).isEqualTo(districts);
    }



}
