package com.iya.energy.electric.model.dto;

import com.iya.energy.member.model.dto.MemberDTO;
import lombok.*;

@Data
public class ElectricDTO {

    private int electric_id;
    private String custNo;           // 고객번호
    private String meterNo;          // 계기번호
    private String mr_ymd;           // 조회연월일 (yyyyMMdd)
    private String mr_hhmi;          // 조회시분 (hhmm)
    private String multi_meter_yn;   // 다계기 여부 (Y/N)
    private String vld_pwrr;         // 유효전력
    private double pwr_qty;          // 전력량 (kWh)
    private MemberDTO user_id;
}