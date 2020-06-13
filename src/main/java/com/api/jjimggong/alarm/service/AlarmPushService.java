package com.api.jjimggong.alarm.service;

import com.api.jjimggong.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AlarmPushService {

    @Autowired
    private AlarmPushClient alarmPushClient;

    public void push(MemberDto Member, String message){
        alarmPushClient.push(Member.getMemberId(), message);
    }
}
