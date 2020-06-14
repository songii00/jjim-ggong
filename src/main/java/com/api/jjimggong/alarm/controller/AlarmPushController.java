package com.api.jjimggong.alarm.controller;

import com.api.jjimggong.member.dto.MemberDto;
import com.api.jjimggong.alarm.dto.AlarmDto;
import com.api.jjimggong.alarm.service.AlarmPushService;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
    public AlarmDto.Response pushAlarm(@PathVariable String message) throws TelegramApiException {
        alarmPushService.push(new MemberDto("1076526392", "송이"),message);
        return AlarmDto.Response.SUCCESS();
    }

    @ExceptionHandler(TelegramApiException.class)
    public AlarmDto.Response error(TelegramApiException e){
        return AlarmDto.Response.FAIL(e.getMessage());
    }
}
