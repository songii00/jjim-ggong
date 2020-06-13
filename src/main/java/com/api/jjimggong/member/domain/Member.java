package com.api.jjimggong.member.domain;

import com.api.jjimggong.alarm.domain.Alarm;
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
    private List<Alarm> alarms = new ArrayList<>();

    public void addAlarm(Alarm alarm){
        alarms.add(alarm);
    }
}
