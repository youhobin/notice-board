package com.example.noticeboard.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@AllArgsConstructor
@Builder
@Getter
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String password;

    private String email;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role role;

    protected Member() {
    }

    public void mapToHashPassword(String hashPassword) {
        this.password = hashPassword;
    }
}
