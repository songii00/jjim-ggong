package com.api.jjimggong.alarm.service;

import com.api.jjimggong.alarm.dto.ActionState;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartActionCommand implements ActionCommand {
    @Override
    public ActionState getAction() {
        return ActionState.START;
    }

    @Override
    public void execute(SendMessage sendMessage) {
        sendMessage.setReplyMarkup(getMenuButtons());
        sendMessage.setText(getGreetings());
    }

    private InlineKeyboardMarkup getMenuButtons(){
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        rowInline.add(new InlineKeyboardButton().setText("상품조회")
                .setCallbackData(ActionState.SEARCH_PRODUCT.getActionName()));

        rowInline.add(new InlineKeyboardButton().setText("태그추가")
                .setCallbackData(ActionState.ADD_TAG.getActionName()));

        rowsInline.add(rowInline);
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }

    private String getGreetings(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("안녕하세요~ 찜꽁입니다!\n");
        stringBuilder.append("관심있는 상품이나 태그를 검색하세요.");
        return stringBuilder.toString();
    }
}
