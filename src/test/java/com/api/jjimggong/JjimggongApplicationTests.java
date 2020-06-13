package com.api.jjimggong;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootTest
class JjimggongApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void JPA_테이블생성(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();
    }

}
