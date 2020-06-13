package com.api.jjimggong.product.domain;

import com.api.jjimggong.alarm.domain.Alarm;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id @GeneratedValue
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;
    /**
     * 상품 노출 시작 일자
     */
    @UpdateTimestamp
    @Column(name = "reserve_start_date")
    private LocalDate reserveStartDate;
    /**
     * 상품 노출 종료 일자
     */
    @UpdateTimestamp
    @Column(name = "reserve_end_date")
    private LocalDate reserveEndDate;

    @OneToMany(mappedBy = "product")
    private List<Alarm> alarms = new ArrayList<>();

}
