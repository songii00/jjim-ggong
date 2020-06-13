package com.api.jjimggong.push.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="push", url = "${push.host}/bot${push.tocken}")
public interface PushClient {

    @GetMapping("/sendmessage")
    String push(@RequestParam("chat_id") String clientId, @RequestParam("text") String message);
}
