package com.example.noticeboard.controller;

import com.example.noticeboard.service.MemberService;
import com.example.noticeboard.service.dto.member.MemberCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/auth/member/save")
    public String memberSave(Model model) {
        model.addAttribute("form", new MemberCreateRequestDto());
        return "member/createMemberForm";
    }

    @PostMapping("/auth/member/save")
    public String createMember(@ModelAttribute MemberCreateRequestDto form) {
        memberService.saveMember(form.toEntity());
        return "redirect:/";
    }

    @GetMapping("/auth/member/login")
    public String memberLogin() {
        return "member/memberLogin";
    }
}
