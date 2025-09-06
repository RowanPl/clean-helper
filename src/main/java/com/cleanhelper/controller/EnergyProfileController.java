package com.cleanhelper.controller;

import com.cleanhelper.dto.EnergyProfileDTO;
import com.cleanhelper.service.EnergyProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/energy-profiles")
public class EnergyProfileController {
    private final EnergyProfileService energyProfileService;

    public EnergyProfileController(EnergyProfileService energyProfileService) {
        this.energyProfileService = energyProfileService;
    }

    @GetMapping
    public List<EnergyProfileDTO> all() {
        return energyProfileService.findAll();
    }

    @PostMapping
    public EnergyProfileDTO create(@RequestBody EnergyProfileDTO dto) {
        return energyProfileService.save(dto);
    }
}
