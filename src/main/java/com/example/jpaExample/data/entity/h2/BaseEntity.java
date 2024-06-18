package com.example.jpaExample.data.entity.h2;
/****************************************************************************************
 * Copyright(c) 2021-2023 Kyobo Book Centre All right reserved.
 * This software is the proprietary information of Kyobo Book.
 *
 * Revision History
 * Author                         Date          Description
 * --------------------------     ----------    ----------------------------------------
 * hys1753@kyobobook.co.kr        2024-03-05
 *
 ****************************************************************************************/

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : BaseEntity
 * @Date : 2024-03-05
 * @description : Base Entity를 사용해서 시간을 넣어도 되지만 Spring Data JPA 는 Auditing을 제공한다.
 */
@MappedSuperclass // 상속된 엔티티에 매핑정보가 적용되도록 지정. (해당 클래스 자체에 대해 매핑되는 테이블이 존재하지 않기 때문에 하위 클래스의 테이블에만 영향을 미칭)
public class BaseEntity {
    @Column(name = "CREATE_TIME", updatable = false)
    private LocalDateTime createTime;
    @Column(name = "AMEND_TIME")
    private LocalDateTime amendTime;

    @PrePersist // persis(insert) 하기 전에 호출한다.
    public void before() {
        LocalDateTime now = LocalDateTime.now();
        this.createTime = now;
        this.amendTime = now;
    }

    @PreUpdate  // update 하기 전에 호출한다.
    public void always() {
        this.amendTime = LocalDateTime.now();
    }
}
