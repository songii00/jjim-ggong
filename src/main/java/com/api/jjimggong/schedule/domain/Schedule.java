package com.api.jjimggong.schedule.domain;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Schedule {

    @Id @GeneratedValue
    @Column(name = "schedule_id")
    private Long scheduleId;

    /**
     * 예매 시작 일시
     */
    @UpdateTimestamp
    @Column(name = "open_date_time")
    private LocalDateTime openDateTime;
    /**
     * 상영 시간
     */
    @Column(name = "running_time")
    private Integer runningTime;
}
