package com.example.demo.request;

import lombok.Data;

@Data
public class MemberCreationRequest {
    private String memberId;
    private String Email;
    private boolean avaliable = true;
}
