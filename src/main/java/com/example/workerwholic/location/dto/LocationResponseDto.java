package com.example.workerwholic.location.dto;

import com.example.workerwholic.location.entity.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationResponseDto {
    private String locationName;
    private Long id;

    public LocationResponseDto(Location location) {
        this.locationName = location.getLocationName();
        this.id = location.getId();
    }
}

