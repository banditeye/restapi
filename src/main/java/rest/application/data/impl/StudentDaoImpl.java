package rest.application.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rest.application.data.StudentDao;
import rest.application.model.Member;
import rest.application.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Komputer on 26.05.2016.
 */


@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private EntityManager em;


    @Override
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public Student findByEmail(String email) {
        CriteriaBuilder cb;
        cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = cb.createQuery(Student.class);
        Root<Student> student = criteria.from(Student.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(student).where(cb.equal(student.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public List<Student> findAllOrderedByLogin() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = cb.createQuery(Student.class);
        Root<Student> student = criteria.from(Student.class);

        /*
         * Swap criteria statements if you would like to try out type-safe criteria queries, a new
         * feature in JPA 2.0 criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
         */

        criteria.select(student).orderBy(cb.asc(student.get("login")));
        return em.createQuery(criteria).getResultList();
    }

    @Override
    public void register(Student student) {
        em.persist(student);
        return;
    }
}
