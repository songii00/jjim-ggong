package com.api.jjimggong.push.domain;

import com.api.jjimggong.member.domain.Member;
import com.api.jjimggong.product.domain.Product;
import com.api.jjimggong.tag.domain.Tag;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Push {

    @Id @GeneratedValue
    @Column(name = "alarm_id")
    private Long alarmId;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    /**
     * 등록 일시
     */
    @Column(name = "register_date_time")
    @CreationTimestamp
    private LocalDateTime registerDateTime;

}
