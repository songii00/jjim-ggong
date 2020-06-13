package com.api.jjimggong.alarm.service;

import com.api.jjimggong.alarm.dto.AlarmDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramAlarmBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("=======polling======");
        System.out.println(new AlarmDto.PollingMessage(update).toString());
    }

    @Override
    public String getBotUsername() {
        return "jjimggong_bot";
    }

    @Override
    public String getBotToken() {
        return "1009377497:AAELjo_UxoXPOc-kXH4ZPFKQz1Wyq6HVy1Q";
    }
}
