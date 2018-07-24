package pl.coderslab.dao;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class StudentGroupDao {

    @PersistenceContext
    EntityManager entityManager;



}
