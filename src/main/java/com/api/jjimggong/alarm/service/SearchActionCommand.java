package com.api.jjimggong.alarm.service;

import com.api.jjimggong.alarm.dto.ActionState;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchActionCommand implements ActionCommand {
    @Override
    public ActionState getAction() {
        return ActionState.SEARCH;
    }

    @Override
    public void execute(SendMessage sendMessage) {

        sendMessage.setText(getGreetings());

        if(isSearchProduct(sendMessage)){
            //fixme 상품 db 검색
        }else if(isSearchTag(sendMessage)){
            //fixme 태그 db 검색
        }
        sendMessage.setReplyMarkup(getMenuButtons());
    }

    private boolean isSearchProduct(SendMessage sendMessage) {
        String text = sendMessage.getText();
        String substring = text.substring(0, 5);
        return substring.equals("상품 - ");
    }

    private boolean isSearchTag(SendMessage sendMessage) {
        String text = sendMessage.getText();
        String substring = text.substring(0, 5);
        return substring.equals("태그 - ");
    }

    private InlineKeyboardMarkup getMenuButtons(){
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        rowInline.add(new InlineKeyboardButton().setText("알림설정")
                .setCallbackData(ActionState.ADD_ALARM.getActionName()));

        rowInline.add(new InlineKeyboardButton().setText("취소")
                .setCallbackData(ActionState.CANCEL_ACTION.getActionName()));

        rowsInline.add(rowInline);
        markupInline.setKeyboard(rowsInline);
        return markupInline;
    }

    private String getGreetings(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("검색한 상품을 알림설정할 수 있습니다.\n");
        stringBuilder.append("상품의 예매 오픈일에 맞춰 알려드려요~\n");
        stringBuilder.append("알림을 설정할까요?");
        return stringBuilder.toString();
    }
}
