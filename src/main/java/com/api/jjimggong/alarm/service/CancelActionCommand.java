package com.api.jjimggong.alarm.service;

import com.api.jjimggong.alarm.dto.ActionState;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class CancelActionCommand implements ActionCommand {
    @Override
    public ActionState getAction() {
        return ActionState.CANCEL_ACTION;
    }

    @Override
    public void execute(SendMessage sendMessage) {
        sendMessage.setText("취소되었습니다ㅠㅠ");
        sendMessage.setReplyMarkup(getStartButtons());
    }
}
