package com.frikiteam.events.resource;

import lombok.Data;

@Data
public class DistrictResource {
    private Long id;
    private CityResource city;
}
