package com.api.jjimggong.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Alarm {

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


 /*   public void addTag(Tag tag){
        if(tags == null){
            tags = new ArrayList<>();
        }
        tags.add(tag);
    }

    public void addProduct(Product product){
        if(products == null){
            products = new ArrayList<>();
        }
        products.add(product);
    }
*/
}
