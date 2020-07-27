package net.cinhtau;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

abstract class JPAHibernateTest {

    JPAHibernateTest(){}

    protected static EntityManagerFactory emf;
    protected static EntityManager em;

    @BeforeAll
    public static void init() {
        emf = Persistence.createEntityManagerFactory("H2-TEST");
        em = emf.createEntityManager();
    }


    @AfterAll
    public static void tearDown() {
        em.clear();
        em.close();
        emf.close();
    }
}