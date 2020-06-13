package com.api.jjimggong.member.domain;

import com.api.jjimggong.push.domain.Push;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "client_id")
    private String clientId;

    @OneToMany(mappedBy = "member")
    private List<Push> pushes = new ArrayList<>();

    public void addAlarm(Push push){
        pushes.add(push);
    }
}
