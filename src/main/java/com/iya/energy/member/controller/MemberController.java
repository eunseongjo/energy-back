package com.iya.energy.member.controller;

import com.iya.energy.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberService loginService;

    @Autowired
    public MemberController(MemberService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String name() {
        return "hi login";
    }
}
