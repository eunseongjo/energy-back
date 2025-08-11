package com.iya.energy.electric.controller;

import com.iya.energy.electric.model.dto.ElectricDTO;
import com.iya.energy.electric.model.service.ElectricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/electric")
public class ElectricController {

    private ElectricService electricService;

    @Autowired
    public ElectricController(ElectricService electricService) {
        this.electricService = electricService;
    }

    @GetMapping
    public String name() {
        return "hi electric";
    }

    @GetMapping("/all")
    public String syncAllData(
            @RequestParam String custNo,
            @RequestParam String serviceKey,
            @RequestParam String startDate,  // yyyyMMdd
            @RequestParam String endDate     // yyyyMMdd
    ) {
        try {
            electricService.fetchAndSaveDataForCustomer(custNo, serviceKey, startDate, endDate);
            return "데이터 전체 동기화 완료";
        } catch (Exception e) {
            return "에러 발생: " + e.getMessage();
        }
    }

    @GetMapping("/allData")
    public List<ElectricDTO> getElectricAllData() {
        return electricService.electricAllData();
    }

}
