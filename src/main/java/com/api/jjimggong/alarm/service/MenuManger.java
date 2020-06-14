package com.api.jjimggong.alarm.service;

import com.api.jjimggong.alarm.dto.ActionState;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class MenuManger {

    private final ActionFactory actionFactory;

    public MenuManger(ActionFactory actionFactory){
        this.actionFactory = actionFactory;
    }

    public void createMenu(ActionState actionState, SendMessage message){
        ActionCommand actionCommand = actionFactory.getActionCommand(actionState);
        actionCommand.execute(message);
    }
}
