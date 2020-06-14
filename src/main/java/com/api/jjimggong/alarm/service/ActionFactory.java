package com.api.jjimggong.alarm.service;

import com.api.jjimggong.alarm.dto.ActionState;
import com.api.jjimggong.alarm.service.ActionCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ActionFactory {

    @Autowired
    private List<ActionCommand> actionCommands;

    private Map<ActionState, ActionCommand> commandMap;

    public ActionCommand getActionCommand(ActionState actionState){
        if(commandMap == null){
            commandMap = new HashMap<>();
            for(ActionCommand actionCommand : actionCommands){
                commandMap.put(actionCommand.getAction(), actionCommand);
            }
        }

        return commandMap.get(actionState);
    }
}
