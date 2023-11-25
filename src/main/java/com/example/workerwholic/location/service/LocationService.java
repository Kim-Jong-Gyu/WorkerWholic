package com.example.workerwholic.location.service;

import com.example.workerwholic.location.dto.LocationRequestDto;
import com.example.workerwholic.location.dto.LocationResponseDto;
import com.example.workerwholic.location.entity.Location;
import com.example.workerwholic.location.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;
    public List<Location> getLocationlist() {
        List<Location> locations = locationRepository.findAll();
        return locations;
    }

    public LocationResponseDto getLocation(Long id) {
     Location location = locationRepository.findById(id).orElseThrow(
             () -> new IllegalArgumentException("선택한 지역 존재하지 않습니다.")
     );
        return new LocationResponseDto(location);
    }
}
