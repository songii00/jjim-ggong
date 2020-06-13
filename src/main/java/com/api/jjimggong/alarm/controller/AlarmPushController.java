package com.api.jjimggong.alarm.controller;

import com.api.jjimggong.member.dto.MemberDto;
import com.api.jjimggong.alarm.dto.AlarmDto;
import com.api.jjimggong.alarm.service.AlarmPushService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/push")
public class AlarmPushController {

    private final AlarmPushService alarmPushService;

    public AlarmPushController(AlarmPushService alarmPushService){
        this.alarmPushService = alarmPushService;
    }

    /**
     * 알림 메시지 푸쉬
     * @param message
     * @return
     */
    @GetMapping("/{message}")
    public AlarmDto.Response pushAlarm(@PathVariable String message){
        alarmPushService.push(new MemberDto("1076526392", "송이"),message);
        return AlarmDto.Response.SUCCESS();
    }

}
