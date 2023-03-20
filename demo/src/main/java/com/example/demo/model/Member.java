package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {
//    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @Column(nullable = false, unique = true)
    private String memberId;
    @Column(nullable = false, unique = true)
    private String Email;

    private boolean avaliable = true;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;
}
