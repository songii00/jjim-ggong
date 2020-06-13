package com.api.jjimggong.alarm.config;

import com.api.jjimggong.alarm.service.TelegramAlarmBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@Configuration
public class AlarmConfig {

    @Bean
    public TelegramBotsApi telegramBotsApi(){
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TelegramAlarmBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        return telegramBotsApi;
    }
}
