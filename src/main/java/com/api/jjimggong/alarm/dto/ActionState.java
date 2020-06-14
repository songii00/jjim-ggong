package com.api.jjimggong.alarm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActionState {
   START("/start"),
   SEARCH_PRODUCT("/search-product"),
   ADD_TAG("/add-tag"),
   CANCEL_ACTION("/cancel"),
   SEARCH_TAG("/search-tag"),
   ADD_ALARM("/add-alarm"),
   SEARCH("/search");

   private String actionName;

   public static ActionState getByActionName(String actionName){
      for(ActionState actionState : ActionState.values()){
         if(actionState.getActionName().equals(actionName)){
            return actionState;
         }
      }
      return SEARCH;
   }

}
