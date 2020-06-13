package com.api.jjimggong.push.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
@Getter
public class PushDto {

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
