package com.example.noticeboard.service.dto.member;

import com.example.noticeboard.domain.Member;
import com.example.noticeboard.domain.Role;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class MemberCreateRequestDto {

    private String username;

    private String password;

    private String email;

    private String nickname;

    private Role role;

    public Member toEntity() {
        return Member.builder()
            .username(username)
            .password(password)
            .email(email)
            .nickname(nickname)
            .role(Role.USER)
            .build();
    }
}
