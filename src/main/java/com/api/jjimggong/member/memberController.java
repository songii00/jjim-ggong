package com.api.jjimggong.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class memberController {

    @GetMapping("/id")
    public String id(){
        return "id";
    }
}
