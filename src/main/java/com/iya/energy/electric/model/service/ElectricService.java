package com.iya.energy.electric.model.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iya.energy.electric.model.dao.ElectricMapper;
import com.iya.energy.electric.model.dto.ElectricDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ElectricService {

    private ElectricMapper electricMapper;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public ElectricService(ElectricMapper electricMapper, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.electricMapper = electricMapper;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public void fetchAndSaveDataForCustomer(String custNo, String serviceKey, String startDate, String endDate) throws Exception {
        // startDate, endDate: "yyyyMMdd" 형식
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        LocalDate start = LocalDate.parse(startDate, dateFormatter);
        LocalDate end = LocalDate.parse(endDate, dateFormatter);

        // 15분 간격 반복
        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            for (int hour = 0; hour < 24; hour++) {
                for (int minute = 0; minute < 60; minute += 15) {
                    String dateTime = date.format(dateFormatter) + String.format("%02d%02d", hour, minute);
                    fetchAndSaveSingleTime(custNo, dateTime, serviceKey, "02");
                }
            }
        }
    }

    private void fetchAndSaveSingleTime(String custNo, String dateTime, String serviceKey, String returnType) {
        try {
            String url = String.format(
                    "https://opm.kepco.co.kr:11080/OpenAPI/getMinuteLpData?custNo=%s&dateTime=%s&serviceKey=%s&returnType=%s",
                    custNo, dateTime, serviceKey, returnType
            );

            String json = restTemplate.getForObject(url, String.class);

            JsonNode root = objectMapper.readTree(json);
            JsonNode dataList = root.path("minuteLpDataInfloist");

            for (JsonNode item : dataList) {
                ElectricDTO data = objectMapper.treeToValue(item, ElectricDTO.class);
                electricMapper.insertMinuteLpData(data);
            }
        } catch (Exception e) {
            System.out.println("오류 발생 (datetime=" + dateTime + "): " + e.getMessage());
        }
    }

    public List<ElectricDTO> electricAllData() {
        return electricMapper.selectAllData();
    }
}
