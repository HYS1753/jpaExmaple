package com.example.jpaExample.data.repository.pg;

import com.example.jpaExample.data.entity.pg.AuthorPgEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

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

/**
 * @author : hys1753@kyobobook.co.kr
 * @Project : jpaExample
 * @FileName : AuthorRepositoryTest
 * @Date : 2024-03-07
 * @description :
 */
@Slf4j
@DataJpaTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class AuthorRepositoryTest {
    @Autowired
    private AuthorRepositoryPg authorRepository;
    private AuthorPgEntity authorEntity;

    @BeforeEach
    public void setUp() {
        authorEntity = new AuthorPgEntity();
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
        AuthorPgEntity savedAuthorEntity = authorRepository.save(authorEntity);
        log.info(">>> Saved model: " + savedAuthorEntity.toString());

        // then
        assertThat(savedAuthorEntity.getId()).isNotNull();
        //assertThat(savedAuthorEntity.getAuthorName()).isEqualTo("동일하면 pass 아니면 fail");
    }
}