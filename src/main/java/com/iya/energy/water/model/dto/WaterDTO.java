package com.iya.energy.water.model.dto;

import com.iya.energy.member.model.dto.MemberDTO;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class WaterDTO {

    private int water_id;
    private int cost;
    private int water_usage;
    private LocalDateTime usetime;
    private MemberDTO user_id;
}
