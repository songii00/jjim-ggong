package com.api.jjimggong.push.controller;

import com.api.jjimggong.member.dto.MemberDto;
import com.api.jjimggong.push.dto.PushDto;
import com.api.jjimggong.push.service.PushService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/push")
public class PushController {

    private final PushService pushService;

    public PushController(PushService pushService){
        this.pushService = pushService;
    }

    @GetMapping("/{message}")
    public PushDto.Response pushAlarm(@PathVariable String message){
        pushService.push(new MemberDto("1076526392", "송이"),"안녕");
        return PushDto.Response.SUCCESS();
    }

}
