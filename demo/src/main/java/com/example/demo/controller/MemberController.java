package com.example.demo.controller;

import com.example.demo.model.Member;
import com.example.demo.request.MemberCreationRequest;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/memberAuth")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<Member> createMember (@RequestBody MemberCreationRequest request) {
        return ResponseEntity.ok(memberService.createMember(request));
    }

    @PatchMapping("/member/{memberId}")
    public ResponseEntity<Member> updateMember (@RequestBody MemberCreationRequest request, @PathVariable String memberId) {
        return ResponseEntity.ok(memberService.updateMember(memberId, request));
    }

    @DeleteMapping("/member/{memberId}")
    public ResponseEntity<Void> deleteMember (@PathVariable String memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<Member> readMember (@PathVariable String memberId) {
        return ResponseEntity.ok(memberService.readMember(memberId));
    }

    @GetMapping("/member")
    public ResponseEntity readMembers(@RequestParam(required = false) String memberId) {
        if (memberId == null) {
            return ResponseEntity.ok(memberService.readMembers());
        }
        return ResponseEntity.ok(memberService.readMember(memberId));
    }
}