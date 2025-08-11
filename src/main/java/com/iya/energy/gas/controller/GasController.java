package com.iya.energy.gas.controller;

import com.iya.energy.gas.model.service.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gas")
public class GasController {

    private GasService gasService;

    @Autowired
    public GasController(GasService gasService) {
        this.gasService = gasService;
    }

    @GetMapping
    public String name() {
        return "hi gas";
    }
}
