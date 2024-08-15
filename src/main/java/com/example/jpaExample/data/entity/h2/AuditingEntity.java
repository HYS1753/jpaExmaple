package com.example.jpaExample.data.entity.h2;

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


// 사전에 Application.java 에 @EnableJpaAuditing을 추가해야 한다. (따로 컨피그로 뺴서 다중 DB 사용시 해당 config 에 작성.)
@EntityListeners(AuditingEntityListener.class) // 이벤트가 발생할 때 호출해 줄 Listener 클래스
@MappedSuperclass
@Data
public class AuditingEntity {
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

/**
 * @Bean
 * public AuditorAware<String> auditorProvider() {
 *     return () -> Optional.of(UUID.randomUUID().toString());
 * }
 * 으로 사용자를 특정지어 넣을 수 있다.
 */
