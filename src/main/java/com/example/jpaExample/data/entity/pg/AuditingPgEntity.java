package com.example.jpaExample.data.entity.pg;
/****************************************************************************************
 * Copyright(c) 2021-2023 Kyobo Book Centre All right reserved.
 * This software is the proprietary information of Kyobo Book.
 *
 * Revision History
 * Author                         Date          Description
 * --------------------------     ----------    ----------------------------------------
 * hys1753@kyobobook.co.kr        2024-03-07
 *
 ****************************************************************************************/

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : AuditingPgEntity
 * @Date : 2024-03-07
 * @description :
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Data
public class AuditingPgEntity {
    @CreatedDate // 생성 날짜를 나타내는 필드로 선언
    @Column(name = "CREATE_TIME", updatable = false)
    private LocalDateTime createdTime;

    @LastModifiedDate // 수정 날짜를 나타내는 필드로 선언
    @Column(name = "AMEND_TIME")
    private LocalDateTime amendTime;

    @CreatedBy // 누구에 의해 생성되었는지 지정하는 필드로 선언
    @Column(name = "CREATE_ID", updatable = false)
    private String createdId;

    @LastModifiedBy // 누구에 의해 변경되었는지 지정하는 필드로 선언
    @Column(name = "AMEND_ID")
    private String amendId;

}
