package com.api.jjimggong.alarm.service;

import com.api.jjimggong.alarm.dto.ActionState;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputMessageContent;
import org.telegram.telegrambots.meta.api.objects.inlinequery.inputmessagecontent.InputTextMessageContent;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddTagActionCommand implements ActionCommand {
    @Override
    public ActionState getAction() {
        return ActionState.ADD_TAG;
    }

    @Override
    public void execute(SendMessage sendMessage) {

        // 알림 설정 완료
        sendMessage.setText("태그를 입력하세요.\n 형식 태그 - 태그명 ");
        sendMessage.setReplyMarkup(getStartButtons());
    }
}
