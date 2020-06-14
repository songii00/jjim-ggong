package com.api.jjimggong.alarm.service;

import com.api.jjimggong.alarm.dto.ActionState;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddAlarmActionCommand implements ActionCommand {
    @Override
    public ActionState getAction() {
        return ActionState.ADD_ALARM;
    }

    @Override
    public void execute(SendMessage sendMessage) {

        // 알림 설정 완료
        sendMessage.setText("알림을 설정됬습니다~\n");
        sendMessage.setReplyMarkup(getStartButtons());
    }

}
