package com.iya.energy.gas.model.dto;

import com.iya.energy.member.model.dto.MemberDTO;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class GasDTO {

    private int gas_id;
    private int cost;
    private int gas_usage;
    private LocalDateTime usetime;
    private MemberDTO user_id;
}
