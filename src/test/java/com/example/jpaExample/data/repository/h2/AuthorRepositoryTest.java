package com.example.jpaExample.data.repository.h2;

import com.example.jpaExample.data.entity.h2.AuthorEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

/****************************************************************************************
 * Copyright(c) 2021-2023 Kyobo Book Centre All right reserved.
 * This software is the proprietary information of Kyobo Book.
 *
 * Revision History
 * Author                         Date          Description
 * --------------------------     ----------    ----------------------------------------
 * hys1753@kyobobook.co.kr        2024-03-06
 *
 ****************************************************************************************/

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : AuthorRepositoryTest
 * @Date : 2024-03-06
 * @description :
 */
@Slf4j
@DataJpaTest        // @Transaction을 포함하고 있어 1개의 테스트가 끝나면 Rollback 해 다른 테스트에 영향을 미치지 않음 (DataSource 설정 확인, CRUD 확인)
//@RequiredArgsConstructor  --> Test code 에서는 생성자 DI 하면 안됨 이유는 하단 주석 확인.
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class AuthorRepositoryTest {
    /**
     * No ParameterResolver registered for parameter in constructor  오류
     * 기존에는 의존성 주입을 할 때 생성자를 통한 방법을 사용해서 @Autowired 어노테이션을 생략해서 사용하고 있었다.
     * 이 경우 메인 코드에서는 Spring IoC 컨테이너가 의존성 주입을 담당하기 때문에 생성자를 통한 의존성 주입을 할 때
     * @Autowired 어노테이션을 생략하더라도 스프링 프레임워크가 알아서 잘 처리를 해준다고 한다.
     * 하지만 테스트 코드에서는 Spring 컨테이너가 아니라 JUnit5의 Jupiter가 의존성 주입을 담당하는데
     * @Autowired가 선언된 객체를 탐색하고 Spring 컨테이너에 요청하여 의존성을 주입하게 된다고 한다.
     * 즉, @SpringBootTest 어노테이션은 Spring Boot와 비슷한 환경을 조성해 주는 것일 뿐이라서 테스트 코드에서
     * @Autowired가 생략되어 있다면 Jupiter가 객체를 탐색하지 못하기 때문에 예외가 발생하는 것이다.
     */
    @Autowired
    private AuthorRepository authorRepository;
    private AuthorEntity authorEntity;

    @BeforeEach
    public void setUp() {
        authorEntity = new AuthorEntity();
        authorEntity.setAuthorName("가나다");
        authorEntity.setId("123");
        log.info("setted entity: " + authorEntity.toString());
    }

    @DisplayName("저자 저장 테스트")
    @Test
    @Order(1)
    public void testSave() {
        log.info(">>> Original model: " + authorEntity.toString());

        // given
        // setUP() 에서 데이터 given

        // when
        AuthorEntity savedAuthorEntity = authorRepository.save(authorEntity);
        log.info(">>> Saved model: " + savedAuthorEntity.toString());

        // then
        assertThat(savedAuthorEntity.getId()).isNotNull();
        //assertThat(savedAuthorEntity.getAuthorName()).isEqualTo("동일하면 pass 아니면 fail");
    }
}