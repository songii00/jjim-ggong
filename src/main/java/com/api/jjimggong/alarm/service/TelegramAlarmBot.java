package com.api.jjimggong.alarm.service;

import com.api.jjimggong.alarm.dto.ActionState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramAlarmBot extends TelegramLongPollingBot {

    @Value("${alarm.username}")
    private String userName;
    @Value(("${alarm.token}"))
    private String token;

    @Autowired
    private AlarmPushClient alarmPushClient;

    @Autowired
    private MenuManger menuManger;

    @Override
    public void onUpdateReceived(Update update) {
        String actionName = update.getMessage() == null ?
                update.getCallbackQuery().getData() : update.getMessage().getText();

        ActionState actionState = ActionState.getByActionName(actionName);

        Long chatId = update.getMessage() == null ?
                update.getCallbackQuery().getFrom().getId() : update.getMessage().getChatId();

        SendMessage message = new SendMessage()
                .setChatId(chatId);

        menuManger.createMenu(actionState, message);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        //System.out.println("=======polling======");
        //System.out.println(new AlarmDto.PollingMessage(update).toString());
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
