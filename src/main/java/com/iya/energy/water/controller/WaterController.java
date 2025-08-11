package com.iya.energy.water.controller;

import com.iya.energy.water.model.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/water")
public class WaterController {

    private WaterService waterService;

    @Autowired
    public WaterController(WaterService waterService) {
        this.waterService = waterService;
    }

    @GetMapping
    public String name() {
        return "hi water";
    }
}
