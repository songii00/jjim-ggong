package com.api.jjimggong.alarm.service;

import com.api.jjimggong.alarm.dto.ActionState;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class SearchProductActionCommand implements ActionCommand {
    @Override
    public ActionState getAction() {
        return ActionState.SEARCH_PRODUCT;
    }

    @Override
    public void execute(SendMessage sendMessage) {
        sendMessage.setText("검색하고싶은 상품명을 입력하세요.\n 형식 상품 - 상품명 ");
    }
}
