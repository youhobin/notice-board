package com.example.noticeboard.controller;

import com.example.noticeboard.service.MemberService;
import com.example.noticeboard.service.dto.member.MemberCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/member")
    public Long save(@RequestBody MemberCreateRequestDto memberCreateRequestDto) {
        return memberService.saveMember(memberCreateRequestDto.toEntity());
    }
}
