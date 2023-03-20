package com.example.demo.service;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.request.MemberCreationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> readMembers() {
        return memberRepository.findAll();
    }

    public Member readMember(String memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
            return member.get();
        }

        throw new EntityNotFoundException(
                "Cant find any member under given ID");
    }
    public void deleteMember(String memberId) {
        memberRepository.deleteById(memberId);
    }

    public Member createMember(MemberCreationRequest request) {
        Member member = new Member();
        BeanUtils.copyProperties(request, member);
        return memberRepository.save(member);
    }

    public Member updateMember (String memberId, MemberCreationRequest request) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if (!optionalMember.isPresent()) {
            throw new EntityNotFoundException(
                    "Member not present in the database");
        }

        Member member = optionalMember.get();
        member.setMemberId(request.getMemberId());
        member.setEmail(request.getEmail());
        member.setAvaliable(false);
        return memberRepository.save(member);
    }
}

