package com.example.noticeboard.service;

import com.example.noticeboard.domain.Member;
import com.example.noticeboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Long saveMember(Member member) {
        String hashPassWord = bCryptPasswordEncoder.encode(member.getPassword());
        member.mapToHashPassword(hashPassWord);
        return memberRepository.save(member);
    }

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }

//    public Optional<Member> findByLoginId(String loginId) {
//        return memberRepository.findByLoginId(loginId);
//    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
