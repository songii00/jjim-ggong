package com.api.jjimggong.alarm.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="push", url = "${alarm.push.host}/bot${alarm.push.tocken}")
public interface AlarmPushClient {

    @GetMapping("/sendmessage")
    String push(@RequestParam("chat_id") String clientId, @RequestParam("text") String message);
}
