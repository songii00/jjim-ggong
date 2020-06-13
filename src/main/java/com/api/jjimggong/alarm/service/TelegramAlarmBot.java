package com.api.jjimggong.alarm.service;

import com.api.jjimggong.alarm.dto.AlarmDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramAlarmBot extends TelegramLongPollingBot {

    @Value("${alarm.username}")
    private String userName;
    @Value(("${alarm.token}"))
    private String token;

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("=======polling======");
        System.out.println(new AlarmDto.PollingMessage(update).toString());
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
