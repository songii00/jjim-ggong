package com.api.jjimggong.alarm.dto;

import com.api.jjimggong.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;


@AllArgsConstructor
@Component
@Getter
public class AlarmDto {

    /**
     * 송신 메시지
     */
    @AllArgsConstructor
    public static class Push{
        private MemberDto memberDto;
    }

    /**
     * 수신 메시지
     */
    @Getter
    @ToString
    public static class PollingMessage {
        private Integer id;
        private String firstName;
        private String lastName;
        private Long chatId;
        private String text;

        private PollingMessage(){}

        public PollingMessage(Update update){
            this.id = update.getMessage().getFrom().getId();
            this.firstName = update.getMessage().getFrom().getFirstName();
            this.lastName = update.getMessage().getFrom().getLastName();
            this.chatId = update.getMessage().getChatId();
            this.text = update.getMessage().getText();
        }
    }



    @AllArgsConstructor
    @Getter
    public static class Response {
        private int code;
        private String message;

        public static Response SUCCESS(){
            return new Response(0, "success");
        }
    }
}
