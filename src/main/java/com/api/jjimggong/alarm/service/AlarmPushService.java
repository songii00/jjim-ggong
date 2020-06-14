package com.api.jjimggong.alarm.service;

import com.api.jjimggong.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AlarmPushService {

   /* @Autowired
    private AlarmPushClient alarmPushClient;*/

    @Autowired
    private TelegramAlarmBot telegramAlarmBot;

    public void push(MemberDto memberDto, String message) throws TelegramApiException {
       // alarmPushClient.push(Member.getMemberId(), message);
        SendMessage sendMessage = new SendMessage()
                .setChatId(memberDto.getMemberId())
                .setText(message);

        telegramAlarmBot.execute(sendMessage);
    }
}
