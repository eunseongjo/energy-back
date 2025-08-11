package com.iya.energy.member.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class MemberDTO {

    private int user_id;
    private String email;
    private String password;
    private LocalDateTime create_time;

}
