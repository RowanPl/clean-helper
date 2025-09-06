package com.cleanhelper.controller;

import com.cleanhelper.dto.EnergyProfileDTO;

import com.cleanhelper.dto.EnergyProfileInputDTO;


import com.cleanhelper.dto.EnergyProfileInputDTO;



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

    @GetMapping("/{id}")
    public EnergyProfileDTO get(@PathVariable Long id) {
        return energyProfileService.findById(id);
    }

    @PostMapping
    public EnergyProfileDTO create(@RequestBody EnergyProfileInputDTO dto) {
        return energyProfileService.create(dto);
    }

    @PutMapping("/{id}")
    public EnergyProfileDTO update(@PathVariable Long id, @RequestBody EnergyProfileInputDTO dto) {
        return energyProfileService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        energyProfileService.delete(id);

    }

}
