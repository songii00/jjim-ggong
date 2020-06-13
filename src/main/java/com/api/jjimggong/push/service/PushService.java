package com.api.jjimggong.push.service;

import com.api.jjimggong.member.dto.MemberDto;
import com.api.jjimggong.push.service.PushClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PushService {

    @Autowired
    private PushClient pushClient;

    public void push(MemberDto Member, String message){
        pushClient.push(Member.getMemberId(), message);
    }
}
