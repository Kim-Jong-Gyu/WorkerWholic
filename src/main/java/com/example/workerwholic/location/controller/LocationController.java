package com.example.workerwholic.location.controller;

import com.example.workerwholic.location.dto.LocationRequestDto;
import com.example.workerwholic.location.entity.Location;
import com.example.workerwholic.location.repository.LocationRepository;
import com.example.workerwholic.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class LocationController {

    private final LocationService locationService;
    @GetMapping("/location")
    @ResponseBody
    public List<Location> getLocationlist(){
        return locationService.getLocationlist();
    }

    @GetMapping("/location/{id}")
    @ResponseBody
    public String getLocation(@PathVariable Long id){
        return  locationService.getLocation(id);
    }
}